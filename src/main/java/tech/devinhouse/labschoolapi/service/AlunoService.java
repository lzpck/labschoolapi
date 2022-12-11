package tech.devinhouse.labschoolapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi.exception.Found;
import tech.devinhouse.labschoolapi.exception.NotFound;
import tech.devinhouse.labschoolapi.model.Aluno;
import tech.devinhouse.labschoolapi.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        Optional<Aluno> optionalAluno = alunoRepository.findByCpf(aluno.getCpf());
        if (optionalAluno.isPresent())
            throw new Found("Aluno");
        Aluno save = alunoRepository.save(aluno);
        return save;
    }

    public List<Aluno> consultar() {
        return alunoRepository.findAll();
    }

    public Aluno consultar(Integer codigo) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(codigo);
        if (alunoOptional.isEmpty())
            throw new NotFound("Aluno", codigo);
        Aluno aluno = alunoOptional.get();
        return aluno;
    }

    public List<Aluno> consultarSituacao(String situacao) {
        List<Aluno> alunos = alunoRepository.findAll();
        if (situacao == null)
            return alunos;

        List<Aluno> consulta = new ArrayList<>();
        for (Aluno aluno: alunos) {
            if (aluno.getSituacao().equals(situacao)) {
                consulta.add(aluno);
            }
        }

        return consulta;
    }

    public Aluno atualizar(Integer codigo, String alunoAtualizado) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(codigo);
        if (optionalAluno.isEmpty())
            throw new NotFound("Aluno", codigo);
        Aluno alunoTemp = optionalAluno.get();
        alunoTemp.setSituacao(alunoAtualizado);
        alunoRepository.save(alunoTemp);
        return alunoTemp;
    }

    public void excluir(Integer codigo) {
        boolean existe = alunoRepository.existsById(codigo);
        if (!existe)
            throw new NotFound("Aluno", codigo);
        alunoRepository.deleteById(codigo);

    }
}
