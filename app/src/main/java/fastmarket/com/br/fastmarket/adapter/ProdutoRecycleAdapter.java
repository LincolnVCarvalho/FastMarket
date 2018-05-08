package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.holders.ProdutoViewHolder;
import fastmarket.com.br.fastmarket.model.Produto;

public class ProdutoRecycleAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private Context context;

    public ProdutoRecycleAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.produto_view_holder, parent, false);
        ProdutoViewHolder holder = new ProdutoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProdutoViewHolder viewHolder = (ProdutoViewHolder) holder;
        Produto produto = produtos.get(position);
        viewHolder.nome.setText(produto.getNome());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
