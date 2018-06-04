package fastmarket.com.br.fastmarket.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fastmarket.com.br.fastmarket.R;

public class CoordenadaViewHolder extends RecyclerView.ViewHolder{

    public final TextView coordenada;

    public CoordenadaViewHolder(View itemView) {
        super(itemView);
        coordenada = (TextView) itemView.findViewById(R.id.txtCoordenadaVH);
    }
}
