package tech.devinhouse.labschoolapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_pedagogo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa{

    @Column(nullable = false)
    private Integer atendimentos = 0;

    public Pedagogo (Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf){
        super(nome, telefone, dataNascimento, cpf, codigo);
    }

}
