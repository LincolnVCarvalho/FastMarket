package fastmarket.com.br.fastmarket.dao;

import android.database.sqlite.SQLiteDatabase;

import fastmarket.com.br.fastmarket.db.MainDB;

public class ProdutoDAO {

    public void bruteData(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
    }
}

