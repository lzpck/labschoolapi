package tech.devinhouse.labschoolapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi.exception.Found;
import tech.devinhouse.labschoolapi.exception.NotFound;
import tech.devinhouse.labschoolapi.model.Professor;
import tech.devinhouse.labschoolapi.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepository professorRepository;

    public Professor salvar(Professor professor) {
        Optional<Professor> optionalProfessor = professorRepository.findByCpf(professor.getCpf());
        if (optionalProfessor.isPresent())
            throw new Found("Professor");
        Professor save = professorRepository.save(professor);
        return save;
    }

    public List<Professor> consultar() {
        return professorRepository.findAll();
    }


}
