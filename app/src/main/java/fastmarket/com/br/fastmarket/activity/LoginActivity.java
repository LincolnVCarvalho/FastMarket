package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class LoginActivity extends AppCompatActivity{

    private EditText txtEmail;
    private EditText txtSenha;
    private Button btnEntrar;
    private Button btnCadastrar;
    private TextView lnkEsqueci;
    private List<String> validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        btnCadastrar = findViewById(R.id.btnCadCadastro);
        btnEntrar = findViewById(R.id.btnEntrar);
        lnkEsqueci = findViewById(R.id.lnkEsqueciSenha);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        lnkEsqueci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RecuperaTokenActivity.class);
                startActivity(intent);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();
                if (validacao.isEmpty()) {
                    Usuario u = new Usuario();
                    u.setSenha(txtSenha.getText().toString());
                    u.setEmail(txtEmail.getText().toString());

                    if (new UsuarioDAO().loginUsuario(u)) {
                        if(u.getEmail().equals("adm@fm.com")){
                            Toast.makeText(LoginActivity.this, "Bem Vindo " + u.getEmail(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Preferencias preferencias = new Preferencias(LoginActivity.this);
                            preferencias.saveLogin(txtEmail.getText().toString(), txtSenha.getText().toString());
                            Toast.makeText(LoginActivity.this, "Bem Vindo " + u.getEmail(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            u = new UsuarioDAO().getUsuario(txtEmail.getText().toString());
                            intent.putExtra("usuarioLogado", u);
                            startActivity(intent);
                            finish();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                        loginIcorreto();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Corrigir os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  void loginIcorreto(){
        txtEmail.setText("");
        txtSenha.setText("");
        txtEmail.setError("Usuario ou Senha incorreta");
        txtSenha.setError("Usuario ou Senha incorreta");
        txtEmail.requestFocus();
    }

    public void validaCampos(){
        validacao = new ArrayList<String>();

        if(txtEmail.getText().toString().equals("")) {
            validacao.add("Email");
            txtEmail.setError("Digite um email");
            txtEmail.requestFocus();
        }

        if(txtSenha.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenha.setError("Digite uma senha!");
            txtSenha.requestFocus();
        }
    }
}
