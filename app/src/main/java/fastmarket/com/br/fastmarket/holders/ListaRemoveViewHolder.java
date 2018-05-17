package fastmarket.com.br.fastmarket.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fastmarket.com.br.fastmarket.R;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaRemoveViewHolder extends RecyclerView.ViewHolder{

    public final TextView nomeProdremove;
    public final ImageView btnProdremove;

    public ListaRemoveViewHolder(View itemView) {
        super(itemView);
        nomeProdremove = (TextView) itemView.findViewById(R.id.txtListaFinalizadaPordNome);
        btnProdremove = (ImageView) itemView.findViewById(R.id.btnDeleteListaFinalizada);
    }
}
