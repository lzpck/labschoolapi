package tech.devinhouse.labschoolapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapi.exception.Found;
import tech.devinhouse.labschoolapi.model.Pedagogo;
import tech.devinhouse.labschoolapi.repository.PedagogoRepository;
import tech.devinhouse.labschoolapi.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedagogoService {
    private PedagogoRepository pedagogoRepository;

    public Pedagogo salvar(Pedagogo pedagogo) {
        Optional<Pedagogo> optionalPedagogo = pedagogoRepository.findByCpf(pedagogo.getCpf());
        if (optionalPedagogo.isPresent())
            throw new Found("Professor");
        Pedagogo save = pedagogoRepository.save(pedagogo);
        return save;
    }

    public List<Pedagogo> consultar() {
        return pedagogoRepository.findAll();
    }


}
