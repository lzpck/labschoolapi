package tech.devinhouse.labschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapi.model.Pedagogo;

import java.util.Optional;

public interface PedagogoRepository extends JpaRepository<Pedagogo, Integer> {
    Optional<Pedagogo> findByCpf (long cpf);

}