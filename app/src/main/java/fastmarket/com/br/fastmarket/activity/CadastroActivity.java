package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSenha;
    private EditText txtConfirmaSenha;
    private EditText txtEmail;
    private EditText txtNascimento;
    private EditText txtCpf;
    private Button btnCadastrar;
    private List<String> validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtNome = findViewById(R.id.txtCadNome);
        txtSenha = findViewById(R.id.txtCadSenha);
        txtConfirmaSenha = findViewById(R.id.txtCadSenhaConf);
        txtEmail = findViewById(R.id.txtCadEmail);
        txtNascimento = findViewById(R.id.txtCadNasci);
        txtCpf = findViewById(R.id.txtCadCPF);
        btnCadastrar = findViewById(R.id.btnCadCadastro);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();
                if (validacao.isEmpty()) {
                    Usuario u = new Usuario();
                    u.setNome(txtNome.getText().toString());
                    u.setSenha(txtSenha.getText().toString());
                    u.setEmail(txtEmail.getText().toString());
                    u.setNascimento(txtNascimento.getText().toString());
                    u.setCpf(Integer.parseInt(txtCpf.getText().toString()));

                    if (new UsuarioDAO().addUsuario(u)) {
                        Toast.makeText(CadastroActivity.this, "Cadastro Realizado com Sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else
                        Toast.makeText(CadastroActivity.this, "Erro ao inserir dado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CadastroActivity.this, "Corrigir os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void validaCampos(){
        validacao = new ArrayList<String>();

        if(txtNome.getText().toString().equals("")) {
            validacao.add("Nome");
            txtNome.setError("Digite um nome");
        }
        if(txtSenha.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenha.setError("Digite uma senha!");
        }
        if(txtConfirmaSenha.getText().toString().equals("")){
            validacao.add("Senha");
            txtConfirmaSenha.setError("Confirme a senha!");
        }
        if(!txtSenha.getText().toString().equals(txtConfirmaSenha.getText().toString())) {
            validacao.add("Senha Diferentes");
            txtConfirmaSenha.setError("Senha nao se conhecidem!");
        }
        if(txtEmail.getText().toString().equals("")) {
            validacao.add("Email");
            txtEmail.setError("Digite um email");
        }
        if(txtNascimento.getText().toString().equals("")) {
            validacao.add("Nascimento");
            txtNascimento.setError("Digite uma data");
        }
        if(txtCpf.getText().toString().equals("")) {
            validacao.add("CPF");
            txtCpf.setError("Digite um CPF!");
        }
    }
}
