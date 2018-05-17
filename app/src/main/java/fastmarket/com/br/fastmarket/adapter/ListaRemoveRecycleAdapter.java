package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.holders.ListaRemoveViewHolder;
import fastmarket.com.br.fastmarket.model.Produto;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaRemoveRecycleAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private Context context;

    public ListaRemoveRecycleAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lstremoveprod_view_holder, parent, false);
        ListaRemoveViewHolder holder = new ListaRemoveViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListaRemoveViewHolder listaRemoveViewHolder = (ListaRemoveViewHolder) holder;
        Produto produto = produtos.get(position);
        listaRemoveViewHolder.nomeProdremove.setText(produto.getNome());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
