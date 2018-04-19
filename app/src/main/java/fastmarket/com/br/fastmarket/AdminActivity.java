package fastmarket.com.br.fastmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.model.Usuario;

public class AdminActivity extends AppCompatActivity{

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtSenha;
    private EditText txtNascimento;
    private EditText txtCpf;
    private Button btnSearch;
    private Button btnADD;
    private Button btnDELETE;
    private Button btnUPDATE;
    private Button btnLIST;
    private Button btnDELTABLE;
    private ListView listALLUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txtNome = findViewById(R.id.txtAdminNome);
        txtEmail = findViewById(R.id.txtAdminEmail);
        txtSenha = findViewById(R.id.txtAdminSenha);
        txtNascimento = findViewById(R.id.txtAdminNascimento);
        txtCpf = findViewById(R.id.txtAdminCPF);
        btnADD = findViewById(R.id.btnAdminADD);
        btnDELETE = findViewById(R.id.btnAdminDELETE);
        btnDELTABLE = findViewById(R.id.btnAdminREMOVETABLE);
        btnLIST = findViewById(R.id.btnAdminLIST);
        btnSearch = findViewById(R.id.btnAdminSearch);
        btnUPDATE = findViewById(R.id.btnAdminUPDATE);
        listALLUser = findViewById(R.id.lstViewAdminUserAll);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Usuario> u = new UsuarioDAO().getUsuario();

                for (int i = 0; i < u.size(); i++){
                    Usuario usuario = u.get(i);
                    System.out.println("# " + i + "Nome: " + usuario.getNome() + "Senha: " + usuario.getSenha()+ "Email: " + usuario.getEmail()+ "Nascimento: " + usuario.getNascimento()+ "CPF: " + usuario.getCpf());
                }

                if(u.size() == 0)System.out.println("# Nao existe registro");
            }
        });
    }


    public void showUser(){
        ArrayList<Usuario> u = new UsuarioDAO().getUsuario();

        for (int i = 0; i < u.size(); i++){
            Usuario usuario = u.get(i);
            System.out.print("#" + i + "Nome: " + usuario.getNome() + "Senha: " + usuario.getSenha()+ "Email: " + usuario.getEmail()+ "Nascimento: " + usuario.getNascimento()+ "CPF: " + usuario.getCpf());
        }
    }

    public void delTable(){
        new UsuarioDAO().removerTabela();
    }
}
