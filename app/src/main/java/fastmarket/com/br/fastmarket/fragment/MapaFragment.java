package fastmarket.com.br.fastmarket.fragment;

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
import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.CoordinateRecycleAdapter;
import fastmarket.com.br.fastmarket.helper.Preferencias;

public class MapaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TextView txtAviso;
    private RecyclerView lstvCoo;
    private Button btnProximo;

    private ArrayList<String> corredoresProduto;
    private ArrayList<String> listaAtual;
    private String[] produtos;
    private List<String> coordenate = new ArrayList<>();
    private List<String> infos = new ArrayList<>();
    private String ultimoCorredor = "";
    private int i = 0;


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
        lstvCoo = (RecyclerView) view.findViewById(R.id.lstvCoordenada);
        btnProximo = (Button) view.findViewById(R.id.btnProximoItem);
        txtAviso = (TextView) view.findViewById(R.id.txtSemListaGerada);


        listaAtual = new ArrayList<>(preferencias.getListaAtual());
        if (!listaAtual.isEmpty()) {

            txtAviso.setVisibility(View.INVISIBLE);
            lstvCoo.setVisibility(View.VISIBLE);

            for (String a : listaAtual) {
                a = a.replace("[", "");
                a = a.replace("]", "");
                produtos = a.split(",");
            }

            lstvCoo.setAdapter(new CoordinateRecycleAdapter(coordenate, getActivity()));
            RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            lstvCoo.setLayoutManager(layout);
            prodPorCorre();
        }else {
            txtAviso.setVisibility(View.VISIBLE);
            lstvCoo.setVisibility(View.INVISIBLE);
        }
       /* if(!infos.isEmpty())
            btnProximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    infos.add(coordenate.get(i));

                    if(i<= coordenate.size())
                        i++;
                }
            });
        else {
            infos.add(coordenate.get(i));
            i++;
        }
        refreshLista();*/
        return view;
    }

    private void refreshLista(){
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }

    private void geraCoordenadas(){
        for (final String c : corredoresProduto) {
            switch (c) {
                case "1":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else {
                        coordenate.add("Seu primeiro produto se encontra no primeiro corredor. Ele esta localizado a 3 corredores a sua esquerda.");
                        ultimoCorredor = "1";
                    }
                    break;
                case "2":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no segundo corredor. Ele esta localizado a 2 corredores a sua esquerda.");
                        ultimoCorredor = "2";
                    } else {
                        coordenate.add("Seu produto se encontra no segundo corredor.");
                        ultimoCorredor = "2";
                    }
                    break;
                case "3":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no terceiro corredor. Ele esta localizado a 1 corredores a sua esquerda.");
                        ultimoCorredor = "3";
                    } else {
                        coordenate.add("Seu produto se encontra no terceiro corredor.");
                        ultimoCorredor = "3";
                    }
                    break;
                case "4":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no quarto corredor. Ele esta localizado a sua frente");
                        ultimoCorredor = "4";
                    } else {
                        coordenate.add("Seu produto se encontra no quarto corredor.");
                        ultimoCorredor = "4";
                    }
                    break;
                case "5":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no quinto corredor. Ele esta localizado a 1 corredores a sua direita.");
                        ultimoCorredor = "5";
                    } else {
                        coordenate.add("Seu produto se encontra no quinto corredor.");
                        ultimoCorredor = "5";
                    }
                    break;
                case "6":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no sexto corredor. Ele esta localizado a 2 corredores a sua direita.");
                        ultimoCorredor = "6";
                    } else {
                        coordenate.add("Seu produto se encontra no sexto corredor.");
                        ultimoCorredor = "6";
                    }
                    break;
                case "7":
                    if (c.equals(ultimoCorredor)) {
                        coordenate.add("Seu proximo produto se encontra neste mesmo corredor!");
                    } else if (coordenate.isEmpty()) {
                        coordenate.add("Seu primeiro produto se encontra no setimo corredor. Ele esta localizado a 3 corredores a sua direita.");
                        ultimoCorredor = "7";
                    } else {
                        coordenate.add("Seu produto se encontra no setimo corredor.");
                        ultimoCorredor = "7";
                    }
                    break;

                default:
                    break;
            }
        }
        coordenate.add("Sua lista acabou. Diraja-se ate um caixa!");
    }

    private void prodPorCorre(){
        corredoresProduto = new ArrayList<>();
        for (int i = 0; i < produtos.length; i++){
            String[] aux;
            aux = produtos[i].split("-");
            corredoresProduto.add(aux[1]);
        }
        geraCoordenadas();
    }

}
