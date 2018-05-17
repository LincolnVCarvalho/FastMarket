package fastmarket.com.br.fastmarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.ListaADDRecycleAdapter;
import fastmarket.com.br.fastmarket.adapter.ListaRemoveRecycleAdapter;
import fastmarket.com.br.fastmarket.adapter.UsuarioRecycleAdapter;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.model.Produto;
import fastmarket.com.br.fastmarket.model.Usuario;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView rclAddProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rclAddProd = (RecyclerView) findViewById(R.id.rclListaDeCompra);

        ArrayList<Produto> p = new ProdutoDAO().getAllProdutos();
        rclAddProd.setAdapter(new ListaADDRecycleAdapter(p, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rclAddProd.setLayoutManager(layout);
    }
}
