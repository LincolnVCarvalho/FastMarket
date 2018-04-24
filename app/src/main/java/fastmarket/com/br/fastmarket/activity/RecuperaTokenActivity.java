package fastmarket.com.br.fastmarket.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;
import java.util.Random;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Permissao;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class RecuperaTokenActivity extends AppCompatActivity {

    private EditText txtCelular;
    private Button btnRecupera;
    private EditText txtEmail;
    private  String[] permissoesNescessaria = new String[]{Manifest.permission.SEND_SMS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_token);

        Permissao.validaPermissoes(1, this, permissoesNescessaria);

        txtCelular = findViewById(R.id.txtCelular);
        btnRecupera = findViewById(R.id.btnGerarToken);
        txtEmail = findViewById(R.id.txtEmailRecupera);

        SimpleMaskFormatter celular = new SimpleMaskFormatter("(NN) N NNNN-NNNN");

        MaskTextWatcher maskCelular = new MaskTextWatcher(txtCelular, celular);

        txtCelular.addTextChangedListener(maskCelular);

        btnRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String celular = txtCelular.getText().toString();

                if(new UsuarioDAO().existeUsuario(email)) {
                    Usuario u = new UsuarioDAO().getUsuario(email);

                    String celularRaw = celular.replace("+", "");
                    celularRaw = celularRaw.replace("(", "");
                    celularRaw = celularRaw.replace(")", "");
                    celularRaw = celularRaw.replace(" ", "");
                    celularRaw = celularRaw.replace("-", "");

                    Random rand = new Random();
                    int n = rand.nextInt(9999 - 1000) + 1000;
                    String token = String.valueOf(n);
                    String mensagemSMS = "Codigo de confirmação para alterar senha: " + token;

                    Preferencias preferencias = new Preferencias(RecuperaTokenActivity.this);
                    preferencias.savePreferences(email, celularRaw, token);
                    enviaSMS("+55" + celularRaw, mensagemSMS);
                    alertaSMS();

                }else{
                    txtEmail.setText("");
                    txtEmail.setError("Usuario nao encontrado!");
                    txtEmail.requestFocus();
                }
            }
        });
    }

    private boolean enviaSMS(String celular, String mensagem){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(celular, null, mensagem, null, null);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult( requestCode, permissions, grantResults);
        for(int resultado : grantResults){
            if(resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    private void alertaValidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negada");
        builder.setMessage("Para recuperar sua senha, é nescessario aceitar essa permissão!");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void alertaSMS(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Codigo Enviado");
        builder.setMessage("Uma mensagem de texto foi enviada para seu celular para recuperar sua senha! Abra seu aplicativo de mensagem para resgatar seu codigo!");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(RecuperaTokenActivity.this, EsqueciActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
