package tech.devinhouse.labschoolapi.web;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AtendimentoResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private Long cpf;

    private Integer atendimentos;

}
