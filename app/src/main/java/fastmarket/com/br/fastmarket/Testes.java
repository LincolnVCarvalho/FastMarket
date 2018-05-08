package fastmarket.com.br.fastmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Testes extends AppCompatActivity {


    private static final String[] COUNTRIES = new String[] {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes);

        final TextView teste = (TextView) findViewById(R.id.txtTeste);

        }
}
