package com.desafiojumplabel.jumplabel.dominio.entidade.aluno;

import com.desafiojumplabel.jumplabel.dominio.AbstractEntity;
import com.desafiojumplabel.jumplabel.dominio.entidade.turma.Turma;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
@JsonAutoDetect
public class Aluno extends AbstractEntity<Long> {

    @NotNull
    private String nome;

    @NotNull
    private String matricula;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id_fk")
    private Turma turma;

    @NotNull
    private String turno;

    @JsonCreator
    public Aluno(@JsonProperty("nome") @NotEmpty String nome,
                 @JsonProperty("matricula") @NotEmpty String matricula,
                 @JsonProperty("turma") Turma turma,
                 @JsonProperty("turno") String turno) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
        this.turno = turno;
    }

    public Aluno() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
