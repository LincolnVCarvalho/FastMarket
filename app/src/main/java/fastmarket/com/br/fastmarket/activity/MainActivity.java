package fastmarket.com.br.fastmarket.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.db.Create;
import fastmarket.com.br.fastmarket.db.MainDB;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextView teste;
    private Button btnSair;
    private Button btnTeste;
    private EditText valida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teste = findViewById(R.id.txtTeste);
        btnSair = findViewById(R.id.btnSair);
        btnTeste = findViewById(R.id.btnValidator);
        valida = findViewById(R.id.txtValida);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuarioLogado");

        if(usuario != null)
            teste.setText(usuario.toString());

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferencias preferencias = new Preferencias(MainActivity.this);
                preferencias.limpaPrefes();
                finish();
            }
        });

        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valida.setError("Easopdkasop");
            }
        });


    }
}
