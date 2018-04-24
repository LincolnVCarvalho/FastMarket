package fastmarket.com.br.fastmarket.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fastmarket.com.br.fastmarket.R;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {

   public final TextView nome;

    public UsuarioViewHolder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.txtName_ViewHolder);

    }
}
