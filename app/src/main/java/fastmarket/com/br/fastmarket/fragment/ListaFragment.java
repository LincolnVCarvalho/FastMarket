package fastmarket.com.br.fastmarket.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.activity.MainActivity;
import fastmarket.com.br.fastmarket.adapter.ListaRemoveRecycleAdapter;
import fastmarket.com.br.fastmarket.dao.ListaDAO;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.dao.UsuarioDAO;
import fastmarket.com.br.fastmarket.helper.Preferencias;
import fastmarket.com.br.fastmarket.model.ItensLista;
import fastmarket.com.br.fastmarket.model.Lista;
import fastmarket.com.br.fastmarket.model.Produto;
import fastmarket.com.br.fastmarket.model.Usuario;


public class ListaFragment extends Fragment{

    private static final String ARG_SECTION_NUMBER = "section_number";
    public String[] item = new String[] {"Digite um Produto..."};

    private long idLista;

    private ArrayList<Produto> listaProduto = new ArrayList<>();
    private ArrayList<ItensLista> itensListas;
    private ArrayAdapter<String> adapter;

    private Produto produto;

    private TextView txtListaVazia;
    private RecyclerView rclLista;
    private Button btnCriarLista;
    private AutoCompleteTextView autoLista;

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
                                if(finalizarLista()){
                                    salvaLista();
                                    ((MainActivity)getActivity()).selectFragment(3);
                                }else{

                                }
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

    private boolean finalizarLista() {
        if(listaProduto.size() > 0){
            quickSort(listaProduto, 0, listaProduto.size() - 1);
            for (int i = 0; i < listaProduto.size(); i++) {
                Log.e("QUICK", "Corredor: " + listaProduto.get(i).getCorredor() + " Produto: " + listaProduto.get(i).getNome());
            }
            return true;
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Sua lista esta vazia!")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            txtListaVazia.setVisibility(View.VISIBLE);
                        }
                    });
            builder.create().show();
        }
        return false;
    }

    private void salvaLista(){

        Preferencias preferencias = new Preferencias(getActivity());
        HashMap<String, String> user = preferencias.getDadosUsuario();
        Usuario u = new UsuarioDAO().getUsuario(user.get("loginEmail"));

        idLista = new ListaDAO().criaLista(new Lista(0, u.getId(), getDate()));
        if(idLista != -1){
            if(new ListaDAO().criaItensLista(montaListaProdutos()))
                Toast.makeText(getActivity(), "Ocorreu um irro ao inserir IntensLista", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getActivity(), "Ocorreu um irro ao inserir Lista", Toast.LENGTH_SHORT).show();

        Log.e("#","Lista: " + new ListaDAO().getLista(2));
        for (ItensLista i: new ListaDAO().getItensLista((int) idLista)){
            Log.e("#","ListaItens: " + i.toString());
        }


    }
    private String getDate(){
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = mdformat.format(Calendar.getInstance().getTime());
        return strDate;
    }

    private ArrayList<ItensLista> montaListaProdutos(){
        itensListas = new ArrayList<>();
        for (int i = 0; i < listaProduto.size(); i++){
            itensListas.add(new ItensLista(0, listaProduto.get(i).getId(), (int) idLista,1));
        }
        return itensListas;
    }

    public static void quickSort(ArrayList<Produto> v, int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = v.get((esq + dir) / 2).getCorredor();
        int troca;
        while (esq <= dir) {
            while (v.get(esq).getCorredor() < pivo) {
                esq = esq + 1;
            }
            while (v.get(dir).getCorredor() > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = v.get(esq).getCorredor();
                v.get(esq).setCorredor(v.get(dir).getCorredor());
                v.get(dir).setCorredor(troca);
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda)
            quickSort(v, esquerda, dir);
        if (esq < direita)
            quickSort(v, esq, direita);
    }
}