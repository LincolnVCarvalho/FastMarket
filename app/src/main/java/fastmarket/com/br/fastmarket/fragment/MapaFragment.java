package fastmarket.com.br.fastmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.helper.Preferencias;

public class MapaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ArrayList<String> listaAtual;
    private TextView txtMapa;
    private String[] produtos;
    private ArrayList<String> corredoresProduto;

    public MapaFragment() {
    }

    public static MapaFragment newInstance(int sectionNumber) {
        MapaFragment fragment = new MapaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        Preferencias preferencias = new Preferencias(getActivity());
        listaAtual = new ArrayList<>(preferencias.getListaAtual());
        txtMapa = (TextView) view.findViewById(R.id.txtMapa);
        for (String a : listaAtual) {
            a = a.replace("[", "");
            a = a.replace("]", "");
            produtos = a.split(",");
        }
        mapa();
        return view;
    }

    private void mapa(){
        prodPorCorre();
        char[][] multi = new char[][] {
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'E', '#', '#', '#', '#', 'C',
                        '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', '1', '#', '#', '#', '2', '#', '#', '#', '3', '#', '#', '#', '#', '4', '#', '#', '#', '#', '5',
                        '#', '#', '#', '6', '#', '#', '#', '7', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ',
                        '#', '#', '#', ' ', '#', '#', '#', ' ', '#' },
                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                        '#', '#', '#', '#', '#', '#', '#', '#', '#' }, };

                corredoresProduto.add("100");

        // 0 = entrada 100 = saida (caixa)
        int localAtual = 0;
        txtMapa.setText("Tete");
        // verifica��o do percurso que deve ser feito para concluir a compra
        for (String c : corredoresProduto) {
            int diff = 0;
            String aux = "";
            if (localAtual == 0) {
                if (Integer.parseInt(c) == 4)
                    txtMapa.setText("Siga ate o corredor a sua frente.");
                else if (Integer.parseInt(c) <= 3) {
                    diff = 4 - Integer.parseInt(c);
                    aux = "Vire a direita e entre no " + diff + "° corredor a esquerda";
                    txtMapa.setText(aux);
                } else {
                    diff = Integer.parseInt(c) - 4;
                    aux = "Vire a esquerda e entre no " + diff + "° corredor a direita";
                    txtMapa.setText(aux);
                }
            } else if (Integer.parseInt(c) != 100) {
                if (Integer.parseInt(c) == localAtual) {
                    txtMapa.setText("Seu protudo se encontra nesse corredor.");
                }
                if (Integer.parseInt(c) > localAtual) {
                    diff = Integer.parseInt(c) - localAtual;
                    if (diff == 1) {
                        aux = "Vá ao fundo do mercado, percorra " + diff + " corredor e vire a esquerda.";
                        txtMapa.setText(aux);
                    }else {
                        aux = "Vá ao fundo do mercado, percorra " + diff + " corredores e vire a esquerda.";
                        txtMapa.setText(aux);
                    }
                }
            } else {
                txtMapa.setText("Todos os produtos foram pegos, o caixa se encontra perto da entrada.");
            }
            localAtual = Integer.parseInt(c);
        }


        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < 29; j++) {
                System.out.print(multi[i][j]);
            }
            System.out.print("\n");
        }
    }

    private void prodPorCorre(){
        corredoresProduto = new ArrayList<>();
        for (int i = 0; i < produtos.length; i++){
            String[] aux;
            aux = produtos[i].split("-");
            corredoresProduto.add(aux[1]);
        }
    }

}
