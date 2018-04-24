package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.TextView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.db.Create;
import fastmarket.com.br.fastmarket.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  teste = findViewById(R.id.txtTeste);

        Intent intent = getIntent();
        Usuario u = (Usuario) intent.getParcelableExtra("usuarioLogado");

        teste.setText(u.toString());
*/
    }
}
