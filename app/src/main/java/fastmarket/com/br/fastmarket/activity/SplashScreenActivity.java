package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.HashMap;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.db.Create;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Usuario;

public class SplashScreenActivity extends AppCompatActivity implements Serializable{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        createTables();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        try {
          Preferencias preferencias = new Preferencias(SplashScreenActivity.this);
          HashMap<String, String> user = preferencias.getDadosUsuario();

           if(user.get("loginEmail") != null) {
               Usuario u = new UsuarioDAO().getUsuario(user.get("loginEmail"));
               jaLogado(u);
           }


            Handler handle = new Handler();
            handle.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mostrarLogin();
                }
            }, 5000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void mostrarLogin() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void jaLogado(Usuario usuario){
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void createTables(){
        new Create().createTableUsuario();
    }
}
