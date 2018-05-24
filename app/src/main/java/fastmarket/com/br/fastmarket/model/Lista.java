package fastmarket.com.br.fastmarket.model;

/**
 * Created by 14153142 on 24/05/2018.
 */

public class Lista {
     private int id;
     private int id_Usuario;
     private String dataCriacaoLista;

    public Lista(int id, int id_Usuario, String dataCriacaoLista) {
        this.id = id;
        this.id_Usuario = id_Usuario;
        this.dataCriacaoLista = dataCriacaoLista;
    }

    public Lista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getDataCriacaoLista() {
        return dataCriacaoLista;
    }

    public void setDataCriacaoLista(String dataCriacaoLista) {
        this.dataCriacaoLista = dataCriacaoLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lista lista = (Lista) o;

        if (id != lista.id) return false;
        if (id_Usuario != lista.id_Usuario) return false;
        return dataCriacaoLista.equals(lista.dataCriacaoLista);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_Usuario;
        result = 31 * result + dataCriacaoLista.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", id_Usuario=" + id_Usuario +
                ", dataCriacaoLista='" + dataCriacaoLista + '\'' +
                '}';
    }
}
