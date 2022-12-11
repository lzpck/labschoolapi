package tech.devinhouse.labschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschoolapi.model.Aluno;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByCodigo (Integer codigo);

    Optional<Aluno> findBySituacao(String situacao);

    boolean existsByCodigo(Integer codigo);

    Optional<Aluno> deleteByCodigo(Integer codigo);

    Optional<Aluno> findByCpf (long cpf);

    boolean existsAlunosByCpf (long cpf);
}
