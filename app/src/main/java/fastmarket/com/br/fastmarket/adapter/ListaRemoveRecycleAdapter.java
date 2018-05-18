package fastmarket.com.br.fastmarket.adapter;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
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
    private ArrayList<Produto> listaProduto;
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
    public void onBindViewHolder(@NonNull final ListaRemoveViewHolder holder, int position) {

        holder.nomeProdremove.setText(produtos.get(position).getNome());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick, int layoutPostion) {
                if (isLongClick)
                    Toast.makeText(context, "LONG: " + produtos.get(position).getNome() + " " + produtos.get(position).getPreco(), Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(context, "SHORT: " + produtos.get(position).getNome() + " " + produtos.get(position).getPreco(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }
}
