package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.adapter.Interfaces.ItemClickListener;
import fastmarket.com.br.fastmarket.holders.ListaRemoveViewHolder;
import fastmarket.com.br.fastmarket.model.Produto;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaRemoveRecycleAdapter extends RecyclerView.Adapter<ListaRemoveViewHolder> {

    private List<Produto> produtos;
    private Context context;
    private Produto produto;

    public ListaRemoveRecycleAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public ListaRemoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.lstremoveprod_view_holder, parent, false);

        return new ListaRemoveViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaRemoveViewHolder holder, int position) {
        produto = produtos.get(position);
        holder.nomeProdremove.setText(produto.getNome());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick) {
                if(isLongClick)
                    Toast.makeText(context, "LONG: " + produto.getNome(), Toast.LENGTH_SHORT).show();
                /* if(itemView.getBackground() == null || ((ColorDrawable) itemView.getBackground()).getColor() == 0){
                    itemView.setBackgroundColor(Color.GREEN);
                    btnProdremove.setImageResource(R.drawable.ic_action_cancel);
                }else if(((ColorDrawable) itemView.getBackground()).getColor() == -16711936) {
                    itemView.setBackgroundColor(0x00000000);
                    btnProdremove.setImageResource(R.drawable.ic_action_add); */
                else
                    Toast.makeText(context, "SHORT: " + produto.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    /*
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListaRemoveViewHolder listaRemoveViewHolder = (ListaRemoveViewHolder) holder;
        Produto produto = produtos.get(position);
        listaRemoveViewHolder.nomeProdremove.setText(produto.getNome());
    }*/
}
