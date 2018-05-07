package fastmarket.com.br.fastmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.model.Produto;

public class ProcuraFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String[] COUNTRIES = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio",
            "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    private ArrayList<String> dados;

    private AutoCompleteTextView autoProduto;
    private TextView procuraCorredor;
    private TextView procuraPreco;
    private TextView procuraNome;

    private Produto produto;
    public ProcuraFragment() {
    }

    public static fastmarket.com.br.fastmarket.fragment.ProcuraFragment newInstance(int sectionNumber) {
        fastmarket.com.br.fastmarket.fragment.ProcuraFragment fragment = new fastmarket.com.br.fastmarket.fragment.ProcuraFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_procura, container, false);
        autoProduto = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteProduto);
        dataAutoComplete(autoProduto.getText().toString());
        Log.i("#",autoProduto.getText().toString());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, COUNTRIES);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, new ProdutoDAO().getProdutoNome(autoProduto.getText().toString()));
        autoProduto.setAdapter(adapter);

        procuraCorredor = (TextView) view.findViewById(R.id.txtProcuraCorredor);
        procuraPreco = (TextView) view.findViewById(R.id.txtProcuraPreco);
        procuraNome = (TextView) view.findViewById(R.id.txtProcuraNome);

        autoProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produto = new ProdutoDAO().getProduto(autoProduto.getText().toString());
                procuraNome.setText(produto.getNome());
                procuraPreco.setText(produto.getPreco().toString());
                procuraCorredor.setText(produto.getCorredor());
            }
        });

        return view;
    }

    private void dataAutoComplete(String nome){
       dados = new ProdutoDAO().getProdutoNome(autoProduto.getText().toString());
    }
    }
