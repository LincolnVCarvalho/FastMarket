package fastmarket.com.br.fastmarket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.activity.ListaActivity;
import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.ListaADDRecycleAdapter;
import fastmarket.com.br.fastmarket.adapter.ListaRemoveRecycleAdapter;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.model.Produto;


public class ListaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ArrayList<Produto> listaDeCompra = new ArrayList<>();
    private TextView txtListaVazia;
    private RecyclerView rclLista;
    private Button btnCriarLista;

    public ListaFragment() {
    }

    public static ListaFragment newInstance(int sectionNumber) {
        ListaFragment fragment = new ListaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        txtListaVazia  = (TextView)view.findViewById(R.id.txtListaVazia);
        rclLista = (RecyclerView)view.findViewById(R.id.rclListaFinalizada);
        btnCriarLista = (Button) view.findViewById(R.id.btnCriaLista);

        btnCriarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListaActivity.class);
                startActivity(intent);
            }
        });

        if(listaDeCompra != null){
            txtListaVazia.setVisibility(View.INVISIBLE);
            rclLista.setVisibility(View.VISIBLE);

            ArrayList<Produto> p = new ProdutoDAO().getAllProdutos();
            rclLista.setAdapter(new ListaRemoveRecycleAdapter(p, getActivity()));
            RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rclLista.setLayoutManager(layout);

        }





        return view;
    }
}
