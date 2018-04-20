package fastmarket.com.br.fastmarket.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create {

    public void createTableUsuario(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY, NOME TEXT, SENHA TEXT, EMAIL TEXT, NASCIMENTO TEXT, CPF TEXT)";
        String query = "CREATE TABLE IF NOT EXISTS " + MainDB.TABBELA_USUARIO + colunas;

        db.execSQL(query);
    }
}
