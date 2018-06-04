package fastmarket.com.br.fastmarket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.CoordinateRecycleAdapter;
import fastmarket.com.br.fastmarket.helper.Preferencias;

public class MapaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TextView txtMapa;
    private RecyclerView lstvCoo;

    private ArrayList<String> corredoresProduto;
    private ArrayList<String> listaAtual;
    private String[] produtos;


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
        lstvCoo = (RecyclerView) view.findViewById(R.id.lstvCoordenada);

        for (String a : listaAtual) {
            a = a.replace("[", "");
            a = a.replace("]", "");
            produtos = a.split(",");
        }
        mapa();
        return view;
    }

    private void mapa() {
        prodPorCorre();

        List<String> coordenate = new ArrayList<>();

        for (String c : corredoresProduto) {

            switch (c){
                case "1":
                    coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;
                case "2":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no segundo corredor. Ele esta localizado a 2 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no segundo corredor. Ele esta localizado a 1 corredores a sua direita.");
                    break;
                case "3":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;
                case "4":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;
                case "5":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;
                case "6":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;
                case "7":
                    if(coordenate.isEmpty())
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    else
                        coordenate.add("Seu produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                    break;

                    default:
                        break;
            }
        }

        lstvCoo.setAdapter(new CoordinateRecycleAdapter(coordenate, getActivity()));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        lstvCoo.setLayoutManager(layout);
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
