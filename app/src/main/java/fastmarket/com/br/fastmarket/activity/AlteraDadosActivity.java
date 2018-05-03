package fastmarket.com.br.fastmarket.activity;

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

public class AlteraDadosActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtSenha;
    private EditText txtSenhaC;
    private EditText txtNascimento;
    private EditText txtCpf;
    private Button btnAtualizar;
    private Usuario usuario;
    private List<String> validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados);
        usuario = (Usuario) getIntent().getSerializableExtra("usuarioLogado");

        txtNome = findViewById(R.id.txtAtualizaNome);
        txtEmail = findViewById(R.id.txtAtualizaEmail);
        txtSenha = findViewById(R.id.txtAtualizaSenha);
        txtSenhaC = findViewById(R.id.txtAtualizaSenhaConf);
        txtNascimento = findViewById(R.id.txtAtualizaNome);
        txtCpf = findViewById(R.id.txtAtualizaCPF);
        btnAtualizar = findViewById(R.id.btnAtualizaDados);

        carregaDadods();

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();
                alteraDados();
            }
        });

    }


    public void carregaDadods(){
        if(usuario != null) {
            txtNome.setText(usuario.getNome());
            txtSenha.setText(usuario.getSenha());
            txtEmail.setText(usuario.getEmail());
            txtNascimento.setText(usuario.getNascimento());
            txtCpf.setText(String.valueOf(usuario.getCpf()));
        }else{
            Toast.makeText(this, "Erro ao carregar usuario!", Toast.LENGTH_SHORT).show();
        }
    }

    public void alteraDados(){
        if (validacao.isEmpty()) {
            usuario.setNome(txtNome.getText().toString());
            usuario.setSenha(txtSenhaC.getText().toString());
            usuario.setEmail(txtEmail.getText().toString());
            usuario.setNascimento(txtNascimento.getText().toString());
            usuario.setCpf(Integer.parseInt(txtCpf.getText().toString()));

            if (new UsuarioDAO().updateUsuario(usuario)) {
                Toast.makeText(this, "Pessoa foi alterada com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao alterada pessoa", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Corrigir os campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void validaCampos(){
        validacao = new ArrayList<String>();

        if(txtNome.getText().toString().equals("")) {
            validacao.add("Nome");
            txtNome.setError("Digite um nome");
            txtNome.requestFocus();
        }
        if(txtSenha.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenha.setError("Digite uma senha!");
            txtSenha.requestFocus();
        }
        if(txtSenhaC.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenhaC.setError("Confirme a senha!");
            txtSenhaC.requestFocus();
        }
        if(!txtSenha.getText().toString().equals(txtSenhaC.getText().toString())) {
            validacao.add("Senha Diferentes");
            txtSenhaC.setError("Senha nao se conhecidem!");
            txtSenhaC.requestFocus();
        }
        if(txtEmail.getText().toString().equals("")) {
            validacao.add("Email");
            txtEmail.setError("Digite um email");
            txtEmail.requestFocus();
        }
        if(txtNascimento.getText().toString().equals("")) {
            validacao.add("Nascimento");
            txtNascimento.setError("Digite uma data");
            txtNascimento.requestFocus();
        }
        if(txtCpf.getText().toString().equals("")) {
            validacao.add("CPF");
            txtCpf.setError("Digite um CPF!");
            txtCpf.requestFocus();
        }
    }
}
