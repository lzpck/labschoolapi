package tech.devinhouse.labschoolapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa{


    private String formacao;

    private String experiencia;

    private String estado;

    public Professor (Integer codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, String formacao, String experiencia, String estado){
        super(nome, telefone, dataNascimento, cpf, codigo);
        this.formacao = formacao;
        this.experiencia = experiencia;
        this.estado = estado;
    }
}
