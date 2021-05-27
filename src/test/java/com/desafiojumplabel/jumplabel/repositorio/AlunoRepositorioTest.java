package com.desafiojumplabel.jumplabel.repositorio;

import com.desafiojumplabel.jumplabel.dominio.entidade.aluno.Aluno;
import com.desafiojumplabel.jumplabel.dominio.entidade.turma.Turma;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes aluno repositorio")
class AlunoRepositorioTest {

    @Resource
    private AlunoRepositorio alunoRepositorio;


    @Test
    @DisplayName("Salva Aluno ")
    void salvaAluno(){
        Aluno aluno = criaAluno();

        Aluno alunoSalvo = alunoRepositorio.save(aluno);

        Assertions.assertThat(alunoSalvo).isNotNull();
        Assertions.assertThat(alunoSalvo.getId()).isNotNull();

    }

    @Test
    @DisplayName("Atualiza Aluno ")
    void atualizaAluno(){
        Aluno aluno = criaAluno();

        Aluno alunoSalvo = alunoRepositorio.save(aluno);

        alunoSalvo.setNome("João");

        Aluno alunoAlterado = alunoRepositorio.save(aluno);

        Assertions.assertThat(alunoAlterado).isNotNull();
        Assertions.assertThat(alunoAlterado.getId()).isNotNull();

        Assertions.assertThat(alunoAlterado.getNome()).isEqualTo(alunoAlterado.getNome());


    }

    private Aluno criaAluno(){
        Long quantidadeAlunos = 4L;
        Turma turma = new Turma("Java", "AAC14", 10L);
        return new Aluno("Carlos", "1235", turma, "Noite"  );
    }
}