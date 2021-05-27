package com.desafiojumplabel.jumplabel.dominio.entidade.turma;

import com.desafiojumplabel.jumplabel.dominio.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "turma")
@JsonAutoDetect
public class Turma extends AbstractEntity<Long> {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String codigoTurma;

    private Long quantidadeAlunos;

    public Turma(@NotEmpty String nome, @NotEmpty String codigoTurma, Long quantidadeAlunos) {
        this.nome = nome;
        this.codigoTurma = codigoTurma;
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public Turma() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Long getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Long quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Turma turma = (Turma) o;

        if (nome != null ? !nome.equals(turma.nome) : turma.nome != null) return false;
        if (codigoTurma != null ? !codigoTurma.equals(turma.codigoTurma) : turma.codigoTurma != null) return false;
        return quantidadeAlunos != null ? quantidadeAlunos.equals(turma.quantidadeAlunos) : turma.quantidadeAlunos == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (codigoTurma != null ? codigoTurma.hashCode() : 0);
        result = 31 * result + (quantidadeAlunos != null ? quantidadeAlunos.hashCode() : 0);
        return result;
    }
}
