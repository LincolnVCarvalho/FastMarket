package fastmarket.com.br.fastmarket.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by 14153142 on 24/05/2018.
 */

public class Lista {
    private int id;
    private int id_Usuario;
    private String dataCriacaoLista;
    private ArrayList<String> itensLista;

    public Lista(int id, int id_Usuario, String dataCriacaoLista, ArrayList<String> itensLista) {
        this.id = id;
        this.id_Usuario = id_Usuario;
        this.dataCriacaoLista = dataCriacaoLista;
        this.itensLista = itensLista;
    }

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

    public ArrayList<String> getItensLista() {
        return itensLista;
    }

    public void setItensLista(ArrayList<String> itensLista) {
        this.itensLista = itensLista;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", id_Usuario=" + id_Usuario +
                ", dataCriacaoLista='" + dataCriacaoLista + '\'' +
                ", itensLista=" + itensLista +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return id == lista.id &&
                id_Usuario == lista.id_Usuario &&
                Objects.equals(dataCriacaoLista, lista.dataCriacaoLista) &&
                Objects.equals(itensLista, lista.itensLista);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, id_Usuario, dataCriacaoLista, itensLista);
    }
}