package fastmarket.com.br.fastmarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.RecycleAdapter;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.db.MainDB;
import fastmarket.com.br.fastmarket.model.Usuario;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtSenha;
    private EditText txtNascimento;
    private EditText txtCpf;
    private EditText txtSearch;
    private Button btnSearch;
    private Button btnADD;
    private Button btnDELETE;
    private Button btnUPDATE;
    private Button btnLIST;
    private Button btnDELTABLE;
    private Usuario usuario;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txtNome = findViewById(R.id.txtAdminNome);
        txtEmail = findViewById(R.id.txtAdminEmail);
        txtSenha = findViewById(R.id.txtAdminSenha);
        txtNascimento = findViewById(R.id.txtAdminNascimento);
        txtCpf = findViewById(R.id.txtAdminCPF);
        txtSearch = findViewById(R.id.txtAdminSearchEmail);
        btnADD = findViewById(R.id.btnAdminADD);
        btnDELETE = findViewById(R.id.btnAdminDELETE);
        btnDELTABLE = findViewById(R.id.btnAdminREMOVETABLE);
        btnLIST = findViewById(R.id.btnAdminLIST);
        btnSearch = findViewById(R.id.btnAdminSearch);
        btnUPDATE = findViewById(R.id.btnAdminUPDATE);
        recyclerView = findViewById(R.id.rclViewUser);


        findViewById(R.id.btnAdminADD).setOnClickListener(this);
        findViewById(R.id.btnAdminDELETE).setOnClickListener(this);
        findViewById(R.id.btnAdminREMOVETABLE).setOnClickListener(this);
        findViewById(R.id.btnAdminLIST).setOnClickListener(this);
        findViewById(R.id.btnAdminSearch).setOnClickListener(this);
        findViewById(R.id.btnAdminUPDATE).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btnAdminADD) {
            adicionarPessoa();
        } else if (id == R.id.btnAdminUPDATE) {
            editarPessoa();
        } else if (id == R.id.btnAdminSearch) {
            carregarPessoa();
        } else if (id == R.id.btnAdminDELETE) {
            removerPessoa();
        } else if (id == R.id.btnAdminREMOVETABLE) {
            delTable();
        } else if (id == R.id.btnAdminLIST) {
            showUser();
        }
    }

    public void showUser(){

        ArrayList<Usuario> u = new UsuarioDAO().getUsuarios();

        recyclerView.setAdapter(new RecycleAdapter(u, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

       /* for (int i = 0; i < u.size(); i++){
            Usuario usuario = u.get(i);
            System.out.println("# " + "   ID: " + usuario.getId() + " Nome: " + usuario.getNome() + " Senha: " + usuario.getSenha()+ " Email: " + usuario.getEmail()+ " Nascimento: " + usuario.getNascimento()+ " CPF: " + usuario.getCpf());
        }

        if(u.size() == 0)System.out.println("# Nao existe registro");*/
    }

    public void delTable(){
        new UsuarioDAO().removerTabela();
    }

    private void carregarPessoa() {

        usuario = new UsuarioDAO().getUsuario(txtSearch.getText().toString());

        txtNome.setText(usuario.getNome());
        txtSenha.setText(usuario.getSenha());
        txtEmail.setText(usuario.getEmail());
        txtNascimento.setText(usuario.getNascimento());
        txtCpf.setText(String.valueOf(usuario.getCpf()));
    }

    private void adicionarPessoa() {
        Usuario u = new Usuario();

        u.setNome(txtNome.getText().toString());
        u.setSenha(txtSenha.getText().toString());
        u.setEmail(txtEmail.getText().toString());
        u.setNascimento(txtNascimento.getText().toString());
        u.setCpf(Integer.parseInt(txtCpf.getText().toString()));

        if (new UsuarioDAO().addUsuario(u)) {
            Toast.makeText(this, "Pessoa foi inserida com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } else {
            Toast.makeText(this, "Erro ao inserir pessoa", Toast.LENGTH_SHORT).show();
        }

    }

    private void editarPessoa() {

        usuario.setNome(txtNome.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setNascimento(txtNascimento.getText().toString());
        usuario.setCpf(Integer.parseInt(txtCpf.getText().toString()));

        if (new UsuarioDAO().updateUsuario(usuario)) {
            Toast.makeText(this, "Pessoa foi alterada com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } else {
            Toast.makeText(this, "Erro ao alterada pessoa", Toast.LENGTH_SHORT).show();
        }

    }

    private void removerPessoa() {

        usuario.setNome(txtNome.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setNascimento(txtNascimento.getText().toString());
        usuario.setCpf(Integer.parseInt(txtCpf.getText().toString()));

        if (new UsuarioDAO().removerUsuario(usuario)) {
            Toast.makeText(this, "Pessoa foi removida com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } else {
            Toast.makeText(this, "Erro ao remover pessoa", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        usuario = null;
        txtNome.setText("");
        txtSenha.setText("");
        txtEmail.setText("");
        txtNascimento.setText("");
        txtCpf.setText("");
        txtSearch.setText("");
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "fechando DB...", Toast.LENGTH_SHORT).show();

        /*Lembre-se de fechar o DB quando fechar o app, e certifique-se de que o mesmo
         * não está em uso antes de chamar  MainDB.getInstancia().close();*/
        MainDB.getInstacia().close();

        super.onStop();
    }
}
