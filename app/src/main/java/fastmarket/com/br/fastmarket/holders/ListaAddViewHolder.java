package fastmarket.com.br.fastmarket.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fastmarket.com.br.fastmarket.R;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaAddViewHolder extends RecyclerView.ViewHolder{

    public final TextView nomeProdAdd;
    public final ImageView btnProdAdd;

    public ListaAddViewHolder(View itemView) {
        super(itemView);
        nomeProdAdd = (TextView) itemView.findViewById(R.id.txtListaPordNome);
        btnProdAdd = (ImageView) itemView.findViewById(R.id.btnAddProdLista);
    }
}
