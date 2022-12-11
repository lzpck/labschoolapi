package tech.devinhouse.labschoolapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    @Column(length = 11)
    private Long cpf;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

}
