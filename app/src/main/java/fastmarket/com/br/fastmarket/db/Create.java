package fastmarket.com.br.fastmarket.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create {

    public void createTable(){
        createTableUsuario();
        createTableProduto();
        createTableLista();
        createTableItensLista();
    }

    private void createTableUsuario(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY, NOME TEXT, SENHA TEXT, EMAIL TEXT, NASCIMENTO TEXT, CPF TEXT)";
        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABBELA_USUARIO + colunas;

        db.execSQL(query);
    }

    private void createTableProduto(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY, NOME TEXT, PRECO REAL, CORREDOR INTEGER)";
        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABBELA_PRODUTO + colunas;

        db.execSQL(query);
    }

    private void createTableItensLista(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY, " +
                "LISTA_ID INTEGER NOT NULL, " +
                "PRODUTO_ID INTEGER NOT NULL, " +
                "QTDE INTEGER, " +
                "FOREIGN KEY(LISTA_ID) REFERENCES " + MainDB.TABBELA_LISTA + "(ID), " +
                "FOREIGN KEY(PRODUTO_ID) REFERENCES " + MainDB.TABBELA_PRODUTO + "(ID))";

        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABBELA_ITENS_LISTA + colunas;

        db.execSQL(query);
    }

    private void createTableLista(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY, " +
                "USUARIO_ID INTEGER NOT NULL, " +
                "DATA_LISTA TEXT NOT NULL, " +
                "FOREIGN KEY(USUARIO_ID) REFERENCES " + MainDB.TABBELA_USUARIO + "(ID))";

        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABBELA_LISTA + colunas;

        db.execSQL(query);
    }
}
