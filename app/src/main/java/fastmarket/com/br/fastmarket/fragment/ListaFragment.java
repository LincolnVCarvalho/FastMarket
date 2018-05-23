package fastmarket.com.br.fastmarket.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.activity.ListaActivity;
import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.DropDownItemAdapter;
import fastmarket.com.br.fastmarket.adapter.ListaADDRecycleAdapter;
import fastmarket.com.br.fastmarket.adapter.ListaRemoveRecycleAdapter;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.model.Produto;


public class ListaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    public String[] item = new String[] {"Digite um Produto..."};
    private ArrayList<Produto> listaProduto = new ArrayList<>();

    private Produto produto;
    private TextView txtListaVazia;
    private RecyclerView rclLista;
    private Button btnCriarLista;
    private AutoCompleteTextView autoLista;

    private ArrayAdapter<String> adapter;

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
        autoLista = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteLista);

        autoLista.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                item = getItemsFromDb(s.toString());
                adapter.notifyDataSetChanged();
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, item);
                autoLista.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, COUNTRIES);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, item);
        autoLista.setAdapter(adapter);

        autoLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InputMethodManager inputManager =(InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                produto = new ProdutoDAO().getProduto(autoLista.getText().toString());
                if(produto != null) {
                    if(listaProduto.contains(produto)){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Esse item ja esta em sua lista!")
                                .setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        autoLista.requestFocus();
                                    }
                                });
                        builder.create().show();
                    }else {
                        listaProduto.add(produto);
                    }
                }
                refreshLista();
                autoLista.setText("");
            }
        });


        if(listaProduto.size() > 0){
            txtListaVazia.setVisibility(View.INVISIBLE);
            rclLista.setVisibility(View.VISIBLE);

            rclLista.setAdapter(new ListaRemoveRecycleAdapter(listaProduto, getActivity()));
            RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rclLista.setLayoutManager(layout);

        }else {
            rclLista.setVisibility(View.INVISIBLE);
            txtListaVazia.setVisibility(View.VISIBLE);
        }

        btnCriarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Você deseja finalizar sua lista!?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finalizarLista();
                            }
                        }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                builder.create().show();
            }
        });

        return view;
    }

    public String[] getItemsFromDb(String searchTerm){

        // add items on the array dynamically
        List<String> products = new ProdutoDAO().getProdutoNome(searchTerm);

        int rowCount = products.size();

        String[] item = new String[rowCount];
        int x = 0;

        for (String record : products) {
            item[x] = record;
            x++;
        }

        return item;
    }

    public void refreshLista(){
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }

    private void finalizarLista(){

    }
}