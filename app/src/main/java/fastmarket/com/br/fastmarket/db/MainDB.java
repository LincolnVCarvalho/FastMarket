package fastmarket.com.br.fastmarket.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fastmarket.com.br.fastmarket.myApp;

public class MainDB extends SQLiteOpenHelper{

    private static String NOME_DB = "FM_DB";
    private static  int VERSAO_DB = 1;
    public static String TABBELA_USUARIO = "USUARIO";

    private static MainDB instacia;

    public static MainDB getInstacia(){
        if(instacia == null) new MainDB();
        return instacia;
    }

    private MainDB() {
        super(myApp.getmContext(), NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
