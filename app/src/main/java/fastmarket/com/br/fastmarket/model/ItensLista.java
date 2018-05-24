package fastmarket.com.br.fastmarket.model;

/**
 * Created by 14153142 on 24/05/2018.
 */

public class ItensLista {
    private int id;
    private int id_produto;
    private int id_lista;
    private int qtde;

    public ItensLista(int id, int id_produto, int id_lista, int qtde) {
        this.id = id;
        this.id_produto = id_produto;
        this.id_lista = id_lista;
        this.qtde = qtde;
    }

    public ItensLista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return "ItensLista{" +
                "id=" + id +
                ", id_produto=" + id_produto +
                ", id_lista=" + id_lista +
                ", qtde=" + qtde +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItensLista that = (ItensLista) o;

        if (id != that.id) return false;
        if (id_produto != that.id_produto) return false;
        if (id_lista != that.id_lista) return false;
        return qtde == that.qtde;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_produto;
        result = 31 * result + id_lista;
        result = 31 * result + qtde;
        return result;
    }
}
