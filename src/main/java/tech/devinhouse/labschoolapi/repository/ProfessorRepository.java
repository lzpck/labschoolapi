package tech.devinhouse.labschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapi.model.Aluno;
import tech.devinhouse.labschoolapi.model.Professor;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Optional<Professor> findByCpf (long cpf);

}