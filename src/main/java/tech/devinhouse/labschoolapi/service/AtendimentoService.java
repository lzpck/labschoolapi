package tech.devinhouse.labschoolapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi.exception.NotFound;
import tech.devinhouse.labschoolapi.model.Aluno;
import tech.devinhouse.labschoolapi.model.Pedagogo;
import tech.devinhouse.labschoolapi.model.Pessoa;
import tech.devinhouse.labschoolapi.repository.AlunoRepository;
import tech.devinhouse.labschoolapi.repository.PedagogoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtendimentoService {

/*    private AlunoRepository alunoRepository;
    private PedagogoRepository pedagogoRepository;

    public Pessoa atendimento (Integer codigoAluno, Integer codigoPedagogo) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(codigoAluno);
        if (alunoOptional.isEmpty())
            throw new NotFound("Aluno", codigoAluno);
        Aluno alunoAtendimento = alunoOptional.get();


        Optional<Pedagogo> pedagogoOptional = pedagogoRepository.findById(codigoPedagogo);
        if (pedagogoOptional.isEmpty())
            throw new NotFound("Pedagogo", codigoPedagogo);
        Pedagogo pedagogoAtendimento = pedagogoOptional.get();

    }*/

}
