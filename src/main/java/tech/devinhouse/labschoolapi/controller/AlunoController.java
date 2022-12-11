package tech.devinhouse.labschoolapi.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapi.model.Aluno;
import tech.devinhouse.labschoolapi.service.AlunoService;
import tech.devinhouse.labschoolapi.web.AlunoRequest;
import tech.devinhouse.labschoolapi.web.AlunoResponse;
import tech.devinhouse.labschoolapi.web.SituacaoRequest;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private ModelMapper mapper;
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrarAluno (@RequestBody @Valid AlunoRequest alunoRequest) {
        Aluno aluno = mapper.map(alunoRequest, Aluno.class);
        alunoService.salvar(aluno);
        AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(alunoResponse.getCodigo().toString())).body(alunoResponse);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> consultarCodigo(@PathVariable("codigo") Integer codigo) {
        Aluno aluno = alunoService.consultar(codigo);
        AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(alunoResponse);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> consultarSituacao(@RequestParam(value = "situacao", required = false) String situacao) {
        List<Aluno> alunos = alunoService.consultarSituacao(situacao);
        List<AlunoResponse> alunoResponseList = new ArrayList<>();
        for (Aluno aluno: alunos) {
            AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
            alunoResponseList.add(alunoResponse);
        }
        return ResponseEntity.ok(alunoResponseList);

//        Aluno alunos = alunoService.consultarSituacao(situacao);
//        AlunoResponse alunoResponse = mapper.map(alunos, AlunoResponse.class);
//        return ResponseEntity.ok(alunoResponse);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable("codigo") Integer codigo, @RequestBody SituacaoRequest situacaoRequest) {
        Aluno aluno = alunoService.atualizar(codigo, situacaoRequest.getSituacao());
        AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(alunoResponse);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity excluirAluno(@PathVariable("codigo") Integer codigo) {
        alunoService.excluir(codigo);
        return ResponseEntity.noContent().build();
    }
}
