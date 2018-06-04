package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.holders.CoordenadaViewHolder;

public class CoordinateRecycleAdapter extends RecyclerView.Adapter  {

    private List<String> coordenadas;
    private Context context;


    public CoordinateRecycleAdapter(List<String> coordenadas, Context context) {
        this.coordenadas = coordenadas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coordenada_view_holder, parent, false);
        CoordenadaViewHolder holder = new CoordenadaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CoordenadaViewHolder viewHolder = (CoordenadaViewHolder) holder;
        String aux = coordenadas.get(position);
        viewHolder.coordenada.setText(aux);
    }

    @Override
    public int getItemCount() {
        return coordenadas.size();
    }
}
