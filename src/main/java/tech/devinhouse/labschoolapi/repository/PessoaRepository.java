package tech.devinhouse.labschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
