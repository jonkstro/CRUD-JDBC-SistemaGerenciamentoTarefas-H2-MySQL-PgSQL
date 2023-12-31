package models;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean isConcluido;
    public Tarefa() {
    }
    public Tarefa(Integer id, String nome, String descricao, Boolean isConcluido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.isConcluido = isConcluido;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Boolean getIsConcluido() {
        return isConcluido;
    }
    public void setIsConcluido(Boolean isConcluido) {
        this.isConcluido = isConcluido;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", isConcluido=" + isConcluido
                + "]";
    }

    
}
