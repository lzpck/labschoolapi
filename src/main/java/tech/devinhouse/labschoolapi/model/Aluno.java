package tech.devinhouse.labschoolapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa {

    @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO")
    private String situacao;

    private Float nota;

    private Integer atendimentos = 0;

    public Aluno (Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, String situacao, Float nota){
        super(nome, telefone, dataNascimento, cpf, codigo);
        this.situacao = situacao;
        this.nota = nota;
    }
}
