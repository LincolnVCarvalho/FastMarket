package fastmarket.com.br.fastmarket.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.db.Create;
import fastmarket.com.br.fastmarket.db.MainDB;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (Usuario) getIntent().getSerializableExtra("usuarioLogado");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Teste");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_sair:
                deslogarUser();
                return true;
            case R.id.item_alterardados:
                atulizaDados(usuario);
                return true;
            case R.id.item_historico:
                Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void deslogarUser(){
        Preferencias preferencias = new Preferencias(MainActivity.this);
        preferencias.limpaPrefes();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void atulizaDados(Usuario usuario){

    }
}
