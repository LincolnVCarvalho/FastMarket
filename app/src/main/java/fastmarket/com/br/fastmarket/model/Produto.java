package fastmarket.com.br.fastmarket.model;

public class Produto {

    private int id;
    private  String nome;
    private  Float preco;
    private  int corredor;

    public Produto() {
    }

    public Produto(int id, String nome, Float preco, int corredor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.corredor = corredor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getCorredor() {
        return corredor;
    }

    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", corredor=" + corredor +
                '}';
    }
}
