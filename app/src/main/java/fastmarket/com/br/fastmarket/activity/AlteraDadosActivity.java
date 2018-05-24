package fastmarket.com.br.fastmarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class AlteraDadosActivity extends AppCompatActivity {

    private EditText txtNomeAtualiza;
    private EditText txtEmailAtualiza;
    private EditText txtSenhaAtualiza;
    private EditText txtSenhaCAtualiza;
    private EditText txtNascimentoAtualiza;
    private EditText txtCpfAtualiza;
    private Button btnAtualizar;
    private Usuario usuario;
    private List<String> validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados);
        Preferencias preferencias = new Preferencias(this);
        HashMap<String, String> user = preferencias.getDadosUsuario();
        usuario = new UsuarioDAO().getUsuario(user.get("loginEmail"));

        txtNomeAtualiza = findViewById(R.id.txtAtualizaNome);
        txtEmailAtualiza = findViewById(R.id.txtAtualizaEmail);
        txtSenhaAtualiza = findViewById(R.id.txtAtualizaSenha);
        txtSenhaCAtualiza = findViewById(R.id.txtAtualizaSenhaConf);
        txtNascimentoAtualiza = findViewById(R.id.txtAtualizaNasci);
        txtCpfAtualiza = findViewById(R.id.txtAtualizaCPF);
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
            txtNomeAtualiza.setText(usuario.getNome());
            txtEmailAtualiza.setText(usuario.getEmail());
            txtSenhaAtualiza.setText(usuario.getSenha());
            txtSenhaCAtualiza.setText(usuario.getSenha());
            txtNascimentoAtualiza.setText(usuario.getNascimento());
            txtCpfAtualiza.setText(String.valueOf(usuario.getCpf()));
        }else{
            Toast.makeText(this, "Erro ao carregar usuario!", Toast.LENGTH_SHORT).show();
        }
    }

    public void alteraDados(){
        if (validacao.isEmpty()) {
            usuario.setNome(txtNomeAtualiza.getText().toString());
            usuario.setSenha(txtSenhaCAtualiza.getText().toString());
            usuario.setEmail(txtEmailAtualiza.getText().toString());
            usuario.setNascimento(txtNascimentoAtualiza.getText().toString());
            usuario.setCpf(Integer.parseInt(txtCpfAtualiza.getText().toString()));

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

        if(txtNomeAtualiza.getText().toString().equals("")) {
            validacao.add("Nome");
            txtNomeAtualiza.setError("Digite um nome");
            txtNomeAtualiza.requestFocus();
        }
        if(txtSenhaAtualiza.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenhaAtualiza.setError("Digite uma senha!");
            txtSenhaAtualiza.requestFocus();
        }
        if(txtSenhaCAtualiza.getText().toString().equals("")){
            validacao.add("Senha");
            txtSenhaCAtualiza.setError("Confirme a senha!");
            txtSenhaCAtualiza.requestFocus();
        }
        if(!txtSenhaAtualiza.getText().toString().equals(txtSenhaCAtualiza.getText().toString())) {
            validacao.add("Senha Diferentes");
            txtSenhaCAtualiza.setError("Senha nao se conhecidem!");
            txtSenhaCAtualiza.requestFocus();
        }
        if(txtEmailAtualiza.getText().toString().equals("")) {
            validacao.add("Email");
            txtEmailAtualiza.setError("Digite um email");
            txtEmailAtualiza.requestFocus();
        }
        if(txtNascimentoAtualiza.getText().toString().equals("")) {
            validacao.add("Nascimento");
            txtNascimentoAtualiza.setError("Digite uma data");
            txtNascimentoAtualiza.requestFocus();
        }
        if(txtCpfAtualiza.getText().toString().equals("")) {
            validacao.add("CPF");
            txtCpfAtualiza.setError("Digite um CPF!");
            txtCpfAtualiza.requestFocus();
        }
    }
}
