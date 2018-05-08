package fastmarket.com.br.fastmarket.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import fastmarket.com.br.fastmarket.db.MainDB;
import fastmarket.com.br.fastmarket.model.Produto;

public class ProdutoDAO {

    public ArrayList<Produto> getAllProdutos(){
        SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABBELA_PRODUTO;
        ArrayList<Produto> prod = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                Produto produto = new Produto();
                produto.setId(c.getInt(0));
                produto.setNome(c.getString(1));
                produto.setPreco(c.getFloat(2));
                produto.setCorredor(c.getInt(3));
                prod.add(produto);
            }while (c.moveToNext());
        }
        c.close();
        return prod;
    }

    public void removerTabelaProd(){
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();

        String query = "DROP TABLE IF EXISTS " + MainDB.TABBELA_PRODUTO;

        db.execSQL(query);
    }

    public Produto getProduto(String nome){
        Produto produto = new Produto();
        try {
            SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
            String query = "SELECT * FROM " + MainDB.TABBELA_PRODUTO + " WHERE NOME LIKE '" + nome + "'";
            Cursor c = db.rawQuery(query, null);

            if (c.moveToFirst()) {
                do {
                    produto.setId(c.getInt(0));
                    produto.setNome(c.getString(1));
                    produto.setPreco(c.getFloat(2));
                    produto.setCorredor(c.getInt(3));
                } while (c.moveToNext());
            }
            c.close();
            return produto;
        }catch (Exception e){
            return produto = null;
        }
    }

    public List<String> getProdutoNome(String nome){

        List<String> array = new ArrayList<>();
        SQLiteDatabase db = MainDB.getInstacia().getReadableDatabase();
        String query = "SELECT NOME FROM " + MainDB.TABBELA_PRODUTO + " WHERE NOME LIKE '%" + nome + "%'";
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do{
                array.add(c.getString(0));
            }while (c.moveToNext());
        }
        c.close();
        return array;
    }

    public boolean bruteData(){
        try {
        SQLiteDatabase db = MainDB.getInstacia().getWritableDatabase();
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (1,'Amaciante de carne',6.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (2,'Bicarbonato de sódio',4.50,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (3,'Coentro',3.60,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (4,'Óleo',7.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (5,'Azeite',19.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (6,'Vinagre',6.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (7,'Sal',4.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (8,'Mostarda',6.00,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (9,'Catchup',6.00,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (10,'Orégano',2.00,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (11,'Maionese',6.00,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (12,'Chá',4.00,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (13,'Azeitonas',14.90,3)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (14,'Vassoura/rodo',8.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (15,'Esponjas',3.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (16,'Fósforos',2.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (17,'Isqueiro',4.00,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (18,'Sabão pó',15.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (19,'Detergente',11.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (20,'Sabão pedra',7.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (21,'Amaciante',19.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (22,'Lustra móvel',14.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (23,'Desinfetante',12.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (24,'Água sanitária',6.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (25,'Palha aço',4.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (26,'Inseticida',7.90,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (27,'Papel alumínio',6.50,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (28,'Papel toalha',5.50,4)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (29,'Refrigerante',6.90,1)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (30,'Cerveja',9.60,1)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (31,'Água mineral',4.40,1)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (32,'Palmito',29.90,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (33,'Milho verde',4.50,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (34,'Molho tomate',3.25,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (35,'Queijo ralado',4.50,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (36,'Farinha trigo',6.80,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (37,'Far.mandioca',6.40,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (38,'Maizena',7.50,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (39,'Ervilha verde',3.65,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (40,'Grão de bico',7.45,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (41,'Lentilha',6.14,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (42,'Feijão',6.41,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (43,'Arroz',12.5,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (44,'Aveia',4.00,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (45,'Açúcar',3.75,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (46,'Café',12.80,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (47,'Chocolate pó',8.90,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (48,'Leite longavida',8.90,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (49,'Creme leite',4.85,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (50,'Leite condensado',4.58,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (51,'Leite coco',2.64,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (52,'Coco ralado',2.30,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (53,'Fermento pó',9.90,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (54,'Ovo de codorna',14.90,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (55,'Ovos',10.00,2)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (56,'Lâmina de barbear',14.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (57,'Acetona',7.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (58,'Hidratante',28.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (59,'Creme de barbear',24.78,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (60,'Sabonete',3.87,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (61,'Shampoo',17.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (62,'Creme dental',4.80,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (63,'Absorvente',9.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (64,'Desodorante',14.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (65,'Condicionador',17.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (66,'Algodão',0.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (67,'Escova dentes',11.90,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (68,'Papel higiênico',20.00,5)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (69,'Bolachas',4.85,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (70,'Maçã',3.87,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (71,'Pêras',4.00,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (72,'Bananas',4.50,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (73,'Uvas',3.25,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (74,'Mamão',3.65,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (75,'Melão',7.45,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (76,'Maracujá',9.90,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (77,'Kiwi',12.5,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (78,'Abacaxi',4.85,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (79,'Abacate',3.87,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (80,'Laranja',4.00,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (81,'Limão',4.50,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (82,'Canela',3.25,6)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (83,'Cheiro verde',9.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (84,'Pimenta',14.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (85,'Pepino',17.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (86,'Rúcula',0.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (87,'Gengibre dentes',11.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (88,'Repolho',20.00,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (89,'Cebola',4.85,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (90,'Alho',3.87,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (91,'Tomate',4.00,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (92,'Batata',4.50,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (93,'Cenoura',3.25,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (94,'Chuchu',3.65,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (95,'Vagem',7.45,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (96,'Abobrinha',9.90,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (97,'Beterraba',12.5,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (98,'Pimentão',4.85,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (99,'Couve flor',3.87,7)");
        db.execSQL("INSERT INTO " + MainDB.TABBELA_PRODUTO + " VALUES (100,'Berinjela',4.00,7)");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
