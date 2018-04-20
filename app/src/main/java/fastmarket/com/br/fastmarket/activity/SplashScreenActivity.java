package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.db.Create;

public class SplashScreenActivity extends AppCompatActivity {

    public static final String LOGIN_PREFERENCE = "INFORMACOES_LOGIN_AUTOMATICO";

    @Override
    protected void onCreate(Bundle savedInstanceState){

        new Create().createTableUsuario();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences(LOGIN_PREFERENCE, MODE_PRIVATE);
                String login = prefs.getString("login", null);

                if (login!= null) {
                    // existe configuração salvar
                } else {
                    mostrarLogin();
                }


            }
        }, 5000);
    }

    private void salvaLogin(){
        SharedPreferences.Editor editor = getSharedPreferences(LOGIN_PREFERENCE, MODE_PRIVATE).edit();
        editor.putString("login", "true");
        editor.commit();
    }

    private void mostrarLogin() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
