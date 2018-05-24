package fastmarket.com.br.fastmarket.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fastmarket.com.br.fastmarket.db.MainDB;
import fastmarket.com.br.fastmarket.model.ItensLista;
import fastmarket.com.br.fastmarket.model.Lista;

public class ListaDAO {

    public Lista getLista(int id){
        SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABBELA_LISTA + " WHERE USUARIO_ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        Lista lista = new Lista();

        if(c.moveToFirst()) {
            do{
                lista.setId(c.getInt(0));
                lista.setId_Usuario(c.getInt(1));
                lista.setDataCriacaoLista(c.getString(2));
            }while (c.moveToNext());
        }
        c.close();
        return lista;
    }

    public ArrayList<ItensLista> getItensLista(int id){
        SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABBELA_ITENS_LISTA + " WHERE LISTA_ID = " + id ;
        Cursor c = db.rawQuery(query, null);

        ArrayList<ItensLista> itensListas = new ArrayList<>();

        if(c.moveToFirst()) {
            do{
                ItensLista i = new ItensLista();
                i.setId(c.getInt(0));
                i.setId_lista(c.getInt(1));
                i.setId_produto(c.getInt(2));
                i.setQtde(c.getInt(3));
                itensListas.add(i);
            }while (c.moveToNext());
        }
        c.close();

        return itensListas;
    }

    public long criaLista(Lista lista){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("USUARIO_ID", lista.getId_Usuario());
        cv.put("DATA_LISTA", lista.getDataCriacaoLista());

        return db.insert(MainDB.TABBELA_LISTA, null, cv);
    }

    //TODO
    public boolean criaItensLista(ArrayList<ItensLista> itensLista){
        try {
            SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
            ContentValues cv = new ContentValues();

            for (ItensLista i : itensLista) {
                cv.put("LISTA_ID", i.getId_lista());
                cv.put("PRODUTO_ID", i.getId_produto());
                cv.put("QTDE", i.getQtde());
                db.insert(MainDB.TABBELA_ITENS_LISTA, null, cv);
            }
        }catch (Exception e){
            return true;
        }
        return false;
    }

    public void brute(){
        bruteData();
        bruteDataLISTA();
    }

    public void bruteData(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String query = "INSERT INTO " + MainDB.TABBELA_ITENS_LISTA + "('ID', 'LISTA_ID', 'PRODUTO_ID', 'QTDE') VALUES " +
                "('1', '1', 'data2', 'data2'), " +
                "('2', '1', 'data2', 'data2'), " +
                "('3', '1', 'data2', 'data2'), " +
                "('4', '1', 'data2', 'data2'), " +
                "('5', '1', 'data2', 'data2'), " +
                "('6', '1', 'data2', 'data2'), " +
                "('7', '1', 'data2', 'data2'), " +
                "('8', '1', 'data2', 'data2'), " +
                "('9', '1', 'data2', 'data2'), " +
                "('10', '2', 'data2', 'data2'), " +
                "('11', '2', 'data2', 'data2'), " +
                "('12', '2', 'data2', 'data2'), " +
                "('13', '2', 'data2', 'data2'), " +
                "('14', '2', 'data2', 'data2'), " +
                "('15', '2', 'data2', 'data2'), " +
                "('16', '2', 'data2', 'data2'), " +
                "('17', '2', 'data2', 'data2'), " +
                "('18', '2', 'data2', 'data2'), " +
                "('19', '2', 'data2', 'data2'), " +
                "('20', '2', 'data2', 'data2'), " +
                "('21', '2', 'data2', 'data2'), " +
                "('22', '2', 'data2', 'data2'), " +
                "('23', '2', 'data2', 'data2'), " +
                "('24', '2', 'data2', 'data2'), " +
                "('25', '2', 'data2', 'data2'), " +
                "('26', '2', 'data2', 'data2'), " +
                "('27', '2', 'data2', 'data2'), " +
                "('28', '3', 'data2', 'data2'), " +
                "('29', '3', 'data2', 'data2'), " +
                "('30', '3', 'data2', 'data2'), " +
                "('31', '3', 'data2', 'data2'), " +
                "('32', '4', 'data2', 'data2'), " +
                "('33', '4', 'data2', 'data2'), " +
                "('34', '4', 'data2', 'data2'), " +
                "('35', '4', 'data2', 'data2'), " +
                "('36', '4', 'data2', 'data2'), " +
                "('37', '4', 'data2', 'data2'), " +
                "('38', '4', 'data2', 'data2'), " +
                "('39', '4', 'data2', 'data2'), " +
                "('40', '5', 'data2', 'data2'), " +
                "('41', '5', 'data2', 'data2'), " +
                "('42', '5', 'data2', 'data2'), " +
                "('43', '5', 'data2', 'data2'), " +
                "('44', '5', 'data2', 'data2'), " +
                "('45', '5', 'data2', 'data2'), " +
                "('46', '6', 'data2', 'data2'), " +
                "('47', '6', 'data2', 'data2'), " +
                "('48', '6', 'data2', 'data2'), " +
                "('49', '6', 'data2', 'data2'), " +
                "('50', '6', 'data2', 'data2'), " +
                "('50', '6', 'data2', 'data2'), " +
                "('51', '6', 'data2', 'data2'), " +
                "('52', '6', 'data2', 'data2'), " +
                "('53', '7', 'data2', 'data2'), " +
                "('54', '7', 'data2', 'data2'), " +
                "('55', '7', 'data2', 'data2'), " +
                "('56', '7', 'data2', 'data2'), " +
                "('57', '7', 'data2', 'data2'), " +
                "('58', '7', 'data2', 'data2'), " +
                "('59', '7', 'data2', 'data2'), " +
                "('60', '7', 'data2', 'data2'), " +
                "('61', '7', 'data2', 'data2'), " +
                "('62', '7', 'data2', 'data2'), " +
                "('63', '7', 'data2', 'data2'), " +
                "('64', '7', 'data2', 'data2'), " +
                "('65', '8', 'data2', 'data2'), " +
                "('66', '8', 'data2', 'data2'), " +
                "('67', '8', 'data2', 'data2'), " +
                "('68', '8', 'data2', 'data2'), " +
                "('69', '8', 'data2', 'data2'), " +
                "('70', '8', 'data2', 'data2'), " +
                "('71', '9', 'data2', 'data2'), " +
                "('72', '9', 'data2', 'data2'), " +
                "('73', '9', 'data2', 'data2'), " +
                "('74', '9', 'data2', 'data2'), " +
                "('75', '9', 'data2', 'data2'), " +
                "('76', '9', 'data2', 'data2'), " +
                "('77', '10', 'data2', 'data2'), " +
                "('78', '10', 'data2', 'data2'), " +
                "('79', '10', 'data2', 'data2'), " +
                "('80', '11', 'data2', 'data2'), " +
                "('81', '11', 'data2', 'data2'), " +
                "('82', '11', 'data2', 'data2'), " +
                "('83', '11', 'data2', 'data2'), " +
                "('84', '11', 'data2', 'data2'), " +
                "('85', '11', 'data2', 'data2'), " +
                "('86', '12', 'data2', 'data2'), " +
                "('87', '12', 'data2', 'data2'), " +
                "('88', '12', 'data2', 'data2'), " +
                "('89', '12', 'data2', 'data2'), " +
                "('90', '12', 'data2', 'data2'), " +
                "('91', '12', 'data2', 'data2'), " +
                "('92', '12', 'data2', 'data2'), " +
                "('93', '13', 'data2', 'data2'), " +
                "('94', '13', 'data2', 'data2'), " +
                "('95', '13', 'data2', 'data2'), " +
                "('96', '13', 'data2', 'data2'), " +
                "('97', '13', 'data2', 'data2'), " +
                "('98', '13', 'data2', 'data2'), " +
                "('99', '13', 'data2', 'data2'), " +
                "('100', '13', 'data2', 'data2') " ;
        db.rawQuery(query, null);
    }

    public void bruteDataLISTA(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String query = "INSERT INTO " + MainDB.TABBELA_LISTA + "('ID', 'USUARIO_ID', 'DATA_LISTA') VALUES " +
                "('1', '3', '20/04/2018'), " +
                "('2', '3', '01/04/2018'), " +
                "('3', '3', '06/03/2018'), " +
                "('4', '3', '30/02/2018'), " +
                "('5', '3', '15/02/2018'), " +
                "('6', '7', '29/04/2018'), " +
                "('7', '7', '10/03/2018'), " +
                "('8', '7', '08/01/2018'), " +
                "('9', '2', '16/03/2018'), " +
                "('10', '4', '19/04/2018'), " +
                "('13', '4', '16/01/2018')" ;
        db.rawQuery(query, null);
    }

    public void removerTabelaItem(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_ITENS_LISTA;

        db.execSQL(query);
    }

    public void removerTabelaLista(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_LISTA;

        db.execSQL(query);
    }
}
