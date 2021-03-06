package fastmarket.com.br.fastmarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String nascimento;
    private int cpf;

    public Usuario(int id, String nome, String email, String senha, String nascimento, int cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }


    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nascimento=" + nascimento +
                ", cpf=" + cpf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                cpf == usuario.cpf &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(nascimento, usuario.nascimento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, email, senha, nascimento, cpf);
    }
}
