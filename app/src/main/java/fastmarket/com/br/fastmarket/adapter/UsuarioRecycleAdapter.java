package fastmarket.com.br.fastmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fastmarket.com.br.fastmarket.R;
import fastmarket.com.br.fastmarket.holders.UsuarioViewHolder;
import fastmarket.com.br.fastmarket.model.Usuario;

public class UsuarioRecycleAdapter extends RecyclerView.Adapter {

    private List<Usuario> usuarios;
    private Context context;

    public UsuarioRecycleAdapter(List<Usuario> usuarios, Context context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.usuario_view_holder, parent, false);
        UsuarioViewHolder holder = new UsuarioViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        UsuarioViewHolder viewHolder = (UsuarioViewHolder) holder;
        Usuario usuario = usuarios.get(position);
        viewHolder.nome.setText(usuario.getNome());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
