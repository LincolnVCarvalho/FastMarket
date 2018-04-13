package fastmarket.com.br.fastmarket.dao;

import fastmarket.com.br.fastmarket.model.Usuario;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import fastmarket.com.br.fastmarket.db.MainDB;
//https://www.youtube.com/watch?v=pAyMF2vhOb8

public class UsuarioDAO {

    public ArrayList<Usuario> getUsuario(){
        SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABBELA_USUARIO;
        ArrayList<Usuario> user = new ArrayList<>();
                Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Usuario usuario = new Usuario(c.getInt(0));
                usuario.setNome(c.getString(1));
                usuario.setEmail(c.getString(2));
                usuario.setSenha(c.getString(3));
                //usuario.setNascimento((Date) c.getString(4));
                usuario.setCpf(c.getInt(5));
                user.add(usuario);
            }while (c.moveToNext());
        }
        c.close();
        return user;
    }

    public boolean addUsuario(Usuario usuario){

        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("ID", usuario.getId());
        cv.put("NOME", usuario.getNome());
        cv.put("SENHA", usuario.getSenha());
        cv.put("EMAIL", usuario.getEmail());
        cv.put("NASCIMENTO", usuario.getNascimento());
        cv.put("CPF", usuario.getCpf());

        return db.insert(MainDB.TABBELA_USUARIO, null, cv) != -1;
    }

    public boolean updateUsuario(Usuario usuario){

        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("ID", usuario.getId());
        cv.put("NOME", usuario.getNome());
        cv.put("SENHA", usuario.getSenha());
        cv.put("EMAIL", usuario.getEmail());
        cv.put("NASCIMENTO", usuario.getNascimento());
        cv.put("CPF", usuario.getCpf());

        String where = "ID = '" + usuario.getId() + "'";

        return db.update(MainDB.TABBELA_USUARIO, cv, where, null) > 0;
    }

    public void removerTabela(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_USUARIO;

        db.execSQL(query,null);
    }

    public boolean removerUsuario(Usuario usuario){

        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "ID = '" + usuario.getId() + "'";

        return db.delete(MainDB.TABBELA_USUARIO, query, null) > 0;
    }

}
