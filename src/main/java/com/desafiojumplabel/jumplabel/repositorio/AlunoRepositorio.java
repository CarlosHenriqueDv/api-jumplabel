package com.desafiojumplabel.jumplabel.repositorio;

import com.desafiojumplabel.jumplabel.dominio.entidade.aluno.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {


}
