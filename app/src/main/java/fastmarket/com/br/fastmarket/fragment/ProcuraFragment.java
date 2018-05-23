package fastmarket.com.br.fastmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.dao.ProdutoDAO;
import fastmarket.com.br.fastmarket.model.Produto;

public class ProcuraFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String TAG = "CustomAutoComplete";

    public String[] item = new String[] {"Digite um Produto..."};
    private ArrayList<String> dados;

    public AutoCompleteTextView autoProduto;
    private TextView procuraCorredor;
    private TextView procuraPreco;
    private TextView procuraNome;

    private ArrayAdapter<String> adapter;

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
        procuraCorredor = (TextView) view.findViewById(R.id.txtProcuraCorredor);
        procuraPreco = (TextView) view.findViewById(R.id.txtProcuraPreco);
        procuraNome = (TextView) view.findViewById(R.id.txtProcuraNome);

        autoProduto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // if you want to see in the logcat what the user types
                Log.e(TAG, "User input: " + s);
                item = getItemsFromDb(s.toString());
                adapter.notifyDataSetChanged();
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, item);
                autoProduto.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, COUNTRIES);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, item);
        autoProduto.setAdapter(adapter);



        autoProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InputMethodManager inputManager =(InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                produto = new ProdutoDAO().getProduto(autoProduto.getText().toString());
                if(produto != null) {
                    procuraNome.setText(produto.getNome());
                    procuraPreco.setText("R$ " + produto.getPreco().toString().replace(".", ","));
                    procuraCorredor.setText(String.valueOf(produto.getCorredor()));
                }
                autoProduto.setText("");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
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

}
