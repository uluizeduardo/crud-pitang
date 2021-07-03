package model.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;

    private String senha;

    private List<Contato> telefones = new ArrayList<>();

    public Usuario(){

    }

    public Usuario(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    //Metodo para adicionar telefone
    public void addTelefone(Contato telefone){
        telefones.add(telefone);
    }

    //Metodo para remover telefone
    public void removerTelefone(Contato telefone){
        telefones.remove(telefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getId().equals(usuario.getId()) && getNome().equals(usuario.getNome()) && getEmail().equals(usuario.getEmail()) && getSenha().equals(usuario.getSenha()) && telefones.equals(usuario.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEmail(), getSenha(), telefones);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
