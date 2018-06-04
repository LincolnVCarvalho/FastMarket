package fastmarket.com.br.fastmarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.ExpandableListViewAdapter;
import fastmarket.com.br.fastmarket.dao.ListaDAO;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.Lista;
import fastmarket.com.br.fastmarket.model.Usuario;

public class HistoricoActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private ArrayList<ArrayList<String>> listHashMap;
    private Button btnVoltar;
    private TextView txtNaotem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        txtNaotem = (TextView) findViewById(R.id.txtNaoTemHist);

        listView = (ExpandableListView) findViewById(R.id.listExp);
        if(initData()) {
            txtNaotem.setVisibility(View.INVISIBLE);
            listAdapter = new ExpandableListViewAdapter(this, listDataHeader, listHashMap);
            listView.setAdapter(listAdapter);
        }else
            txtNaotem.setVisibility(View.VISIBLE);

        btnVoltar = (Button) findViewById(R.id.btnVoltarHistorico);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoricoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new ArrayList<>();
        ArrayList<Lista> l;
        Preferencias preferencias = new Preferencias(this);
        HashMap<String, String> user = preferencias.getDadosUsuario();
        Usuario u = new UsuarioDAO().getUsuario(user.get("loginEmail"));
        l = new ListaDAO().getHistoricoLista(u.getId());

        if (l.size()  != 0) {
            txtNaotem.setVisibility(View.INVISIBLE);
            ArrayList<String> aux;
            ArrayList<ArrayList<String>> listas = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                if (i < l.size())
                    listDataHeader.add(l.get((l.size() - 1) - i).getDataCriacaoLista());
            }

            for (int i = 0; i < 5; i++) {
                if (i < l.size()) {
                    aux = new ArrayList<>();
                    for (String a : l.get((l.size() - 1) - i).getItensLista()) {
                        aux.add(a);
                    }
                    listas.add(aux);
                }
            }

            for (int i = 0; i < 5; i++) {
                if (i < l.size())
                    listHashMap.add(listas.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

}
