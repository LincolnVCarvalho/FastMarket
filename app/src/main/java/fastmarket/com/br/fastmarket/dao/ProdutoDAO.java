package fastmarket.com.br.fastmarket.dao;

import android.database.sqlite.SQLiteDatabase;

import fastmarket.com.br.fastmarket.db.MainDB;

public class ProdutoDAO {

    public void bruteData(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String query = "INSERT INTO " + MainDB.TABBELA_PRODUTO + "('ID', 'NOME', 'PRECO', 'CORREDOR') VALUES " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2'), " +
                "('data1', 'data2', 'data2', 'data2')";
        db.rawQuery(query, null);
    }

    public void removerTabelaProd(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_PRODUTO;

        db.execSQL(query);
    }
}

