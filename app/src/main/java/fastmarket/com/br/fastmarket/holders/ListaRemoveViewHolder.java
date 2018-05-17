package fastmarket.com.br.fastmarket.holders;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.Interfaces.ItemClickListener;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaRemoveViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public final TextView nomeProdremove;
    public final ImageView btnProdremove;
    private ItemClickListener itemClickListener;

    public ListaRemoveViewHolder(View itemView) {
        super(itemView);
        nomeProdremove = (TextView) itemView.findViewById(R.id.txtListaFinalizadaPordNome);
        btnProdremove = (ImageView) itemView.findViewById(R.id.btnDeleteListaFinalizada);

        /*itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);*/

        btnProdremove.setOnClickListener(this);
        btnProdremove.setOnLongClickListener(this);

        /*btnProdremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                }
            }
        });*/
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onItemClick(v, getAdapterPosition(), true);
        return true;
    }
}
