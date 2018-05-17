package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.holders.ListaAddViewHolder;
import fastmarket.com.br.fastmarket.holders.ProdutoViewHolder;
import fastmarket.com.br.fastmarket.model.Produto;

/**
 * Created by 14153142 on 17/05/2018.
 */

public class ListaADDRecycleAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private Context context;

    public ListaADDRecycleAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lstaddproduto_view_holder, parent, false);
        ListaAddViewHolder holder = new ListaAddViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListaAddViewHolder listaAddViewHolder = (ListaAddViewHolder) holder;
        Produto produto = produtos.get(position);
        listaAddViewHolder.nomeProdAdd.setText(produto.getNome());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}