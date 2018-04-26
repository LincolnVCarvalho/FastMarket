package fastmarket.com.br.fastmarket.dao;

import android.database.sqlite.SQLiteDatabase;

import fastmarket.com.br.fastmarket.db.MainDB;

public class ProdutoDAO {

    public void bruteData(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        String query = "INSERT INTO " + MainDB.TABBELA_PRODUTO + "('ID', 'NOME', 'PRECO', 'CORREDOR') VALUES " +
                "('1', 'ARROZ', '10.60', '1'), " +
                "('2', 'FEIJÃO CARIOCA', '7.99', '1'), " +
                "('3', 'FEIJÃO PRETO', '7.99', '1'), " +
                "('4', 'LENTILHA', '6.99', '1'), " +
                "('5', 'ARROZ INTEGRAL', '16.9', '1'), " +
                "('6', 'data2', 'data2', 'data2'), " +
                "('7', 'data2', 'data2', 'data2'), " +
                "('8', 'data2', 'data2', 'data2'), " +
                "('9', 'data2', 'data2', 'data2'), " +
                "('10', 'data2', 'data2', 'data2'), " +
                "('11', 'data2', 'data2', 'data2'), " +
                "('12', 'data2', 'data2', 'data2'), " +
                "('13', 'data2', 'data2', 'data2'), " +
                "('14', 'data2', 'data2', 'data2'), " +
                "('15', 'data2', 'data2', 'data2'), " +
                "('16', 'data2', 'data2', 'data2'), " +
                "('17', 'data2', 'data2', 'data2'), " +
                "('18', 'data2', 'data2', 'data2'), " +
                "('19', 'data2', 'data2', 'data2'), " +
                "('20', 'data2', 'data2', 'data2'), " +
                "('21', 'data2', 'data2', 'data2'), " +
                "('22', 'data2', 'data2', 'data2'), " +
                "('23', 'data2', 'data2', 'data2'), " +
                "('24', 'data2', 'data2', 'data2'), " +
                "('25', 'data2', 'data2', 'data2'), " +
                "('26', 'data2', 'data2', 'data2'), " +
                "('27', 'data2', 'data2', 'data2'), " +
                "('28', 'data2', 'data2', 'data2'), " +
                "('29', 'data2', 'data2', 'data2'), " +
                "('30', 'data2', 'data2', 'data2'), " +
                "('31', 'data2', 'data2', 'data2'), " +
                "('32', 'data2', 'data2', 'data2'), " +
                "('33', 'data2', 'data2', 'data2'), " +
                "('34', 'data2', 'data2', 'data2'), " +
                "('35', 'data2', 'data2', 'data2'), " +
                "('36', 'data2', 'data2', 'data2'), " +
                "('37', 'data2', 'data2', 'data2'), " +
                "('38', 'data2', 'data2', 'data2'), " +
                "('39', 'data2', 'data2', 'data2'), " +
                "('40', 'data2', 'data2', 'data2'), " +
                "('41', 'data2', 'data2', 'data2'), " +
                "('42', 'data2', 'data2', 'data2'), " +
                "('43', 'data2', 'data2', 'data2'), " +
                "('44', 'data2', 'data2', 'data2'), " +
                "('45', 'data2', 'data2', 'data2'), " +
                "('46', 'data2', 'data2', 'data2'), " +
                "('47', 'data2', 'data2', 'data2'), " +
                "('48', 'data2', 'data2', 'data2'), " +
                "('49', 'data2', 'data2', 'data2'), " +
                "('50', 'data2', 'data2', 'data2'), " +
                "('51', 'data2', 'data2', 'data2'), " +
                "('52', 'data2', 'data2', 'data2'), " +
                "('53', 'data2', 'data2', 'data2'), " +
                "('54', 'data2', 'data2', 'data2'), " +
                "('55', 'data2', 'data2', 'data2'), " +
                "('56', 'data2', 'data2', 'data2'), " +
                "('57', 'data2', 'data2', 'data2'), " +
                "('58', 'data2', 'data2', 'data2'), " +
                "('59', 'data2', 'data2', 'data2'), " +
                "('60', 'data2', 'data2', 'data2'), " +
                "('61', 'data2', 'data2', 'data2'), " +
                "('62', 'data2', 'data2', 'data2'), " +
                "('63', 'data2', 'data2', 'data2'), " +
                "('64', 'data2', 'data2', 'data2'), " +
                "('65', 'data2', 'data2', 'data2'), " +
                "('66', 'data2', 'data2', 'data2'), " +
                "('67', 'data2', 'data2', 'data2'), " +
                "('68', 'data2', 'data2', 'data2'), " +
                "('69', 'data2', 'data2', 'data2'), " +
                "('70', 'data2', 'data2', 'data2'), " +
                "('71', 'data2', 'data2', 'data2'), " +
                "('72', 'data2', 'data2', 'data2'), " +
                "('73', 'data2', 'data2', 'data2'), " +
                "('74', 'data2', 'data2', 'data2'), " +
                "('75', 'data2', 'data2', 'data2'), " +
                "('76', 'data2', 'data2', 'data2'), " +
                "('77', 'data2', 'data2', 'data2'), " +
                "('78', 'data2', 'data2', 'data2'), " +
                "('79', 'data2', 'data2', 'data2'), " +
                "('80', 'data2', 'data2', 'data2'), " +
                "('81', 'data2', 'data2', 'data2'), " +
                "('82', 'data2', 'data2', 'data2'), " +
                "('83', 'data2', 'data2', 'data2'), " +
                "('84', 'data2', 'data2', 'data2'), " +
                "('85', 'data2', 'data2', 'data2'), " +
                "('86', 'data2', 'data2', 'data2'), " +
                "('87', 'data2', 'data2', 'data2'), " +
                "('88', 'data2', 'data2', 'data2'), " +
                "('89', 'data2', 'data2', 'data2'), " +
                "('90', 'data2', 'data2', 'data2'), " +
                "('91', 'data2', 'data2', 'data2'), " +
                "('92', 'data2', 'data2', 'data2'), " +
                "('93', 'data2', 'data2', 'data2'), " +
                "('94', 'data2', 'data2', 'data2'), " +
                "('95', 'data2', 'data2', 'data2'), " +
                "('96', 'data2', 'data2', 'data2'), " +
                "('97', 'data2', 'data2', 'data2'), " +
                "('98', 'data2', 'data2', 'data2'), " +
                "('99', 'data2', 'data2', 'data2'), " +
                "('100', 'data2', 'data2', 'data2') ";
        db.rawQuery(query, null);
    }

    public void removerTabelaProd(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_PRODUTO;

        db.execSQL(query);
    }
}

