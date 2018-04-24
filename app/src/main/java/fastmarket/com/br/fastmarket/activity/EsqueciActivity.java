package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.HashMap;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class EsqueciActivity extends AppCompatActivity {

    private Button btnRecupera;
    private EditText txtToken;
    private EditText txtSenha;
    private EditText txtConfirmaSenha;
    private Switch swtMostra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci);


        btnRecupera = findViewById(R.id.btnRecuperaSenha);
        txtToken = findViewById(R.id.txtTokenSenhaSMS);
        txtSenha = findViewById(R.id.txtNovaSenha);
        txtConfirmaSenha = findViewById(R.id.txtNovaSenhaConfirma);
        swtMostra = findViewById(R.id.swtMostraSenha);


        swtMostra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!swtMostra.isChecked()) {
                    txtSenha.setTransformationMethod(new PasswordTransformationMethod());
                    txtConfirmaSenha.setTransformationMethod(new PasswordTransformationMethod());
                }else {
                    txtSenha.setTransformationMethod(null);
                    txtConfirmaSenha.setTransformationMethod(null);
                }
            }
        });
        SimpleMaskFormatter simpleMaskFormatter = new SimpleMaskFormatter("NNNN");
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(txtToken, simpleMaskFormatter);

        txtToken.addTextChangedListener(maskTextWatcher);
        btnRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferencias preferencias = new Preferencias(EsqueciActivity.this);
                HashMap<String, String> user = preferencias.getDadosUsuario();

                String tokenGerado = user.get("token");
                String tokenDigitado = txtToken.getText().toString();
                Usuario u = new UsuarioDAO().getUsuario(user.get("email"));

                if (txtSenha.getText().toString().equals(txtConfirmaSenha.getText().toString())){
                    if (tokenDigitado.equals(tokenGerado)) {
                        u.setSenha(txtConfirmaSenha.getText().toString());
                        if (new UsuarioDAO().updateUsuario(u)) {
                            Toast.makeText(EsqueciActivity.this, "Senha atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                            preferencias.limpaPrefes();
                            Intent intent = new Intent(EsqueciActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(EsqueciActivity.this, "Erro ao atualizar senha!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        txtToken.setText("");
                        txtToken.setError("Token Invalido!");
                        txtToken.requestFocus();
                    }
                } else {
                    txtConfirmaSenha.setText("");
                    txtConfirmaSenha.setError("Senhas não se conhecidem!");
                    txtConfirmaSenha.requestFocus();
                }
            }
        });
    }
}
