package com.desafiojumplabel.jumplabel.endpoint;

import com.desafiojumplabel.jumplabel.dominio.entidade.aluno.Aluno;
import com.desafiojumplabel.jumplabel.error.ResourceNotFoundException;
import com.desafiojumplabel.jumplabel.repositorio.AlunoRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoEndPoint {

    @Resource
    private AlunoRepositorio alunoRepositorio;

    @ApiOperation(value = "Cadastrar novo aluno", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Aluno cadastrado com sucesso!"),
            @ApiResponse(code = 400, message = "Dados Incorretos!"),
            @ApiResponse(code = 500, message = "Erro interno !")
    })
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoRepositorio.save(aluno), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Listar todos alunos", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta realizada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno !")
    })
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(alunoRepositorio.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public  ResponseEntity<?>findAlunoPorId(@PathVariable("id") Long id){

        verificaSeAlunoExiste(id);
        return new ResponseEntity<>(alunoRepositorio.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "atualizar aluno", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizacao realizada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno !"),
            @ApiResponse(code = 400, message = "Dados Incorretos!")
    })
    @PutMapping
    public ResponseEntity<?> alualiza(@RequestBody Aluno aluno){
        verificaSeAlunoExiste(aluno.getId());
        alunoRepositorio.save(aluno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "excluir aluno", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exclusão realizada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno !"),
            @ApiResponse(code = 400, message = "Dados Incorretos!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        verificaSeAlunoExiste(id);
        alunoRepositorio.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verificaSeAlunoExiste(Long id) {

        if (!alunoRepositorio.findById(id).isPresent()){
            throw new ResourceNotFoundException("Aluno não encontrado");
        }
    }


}
