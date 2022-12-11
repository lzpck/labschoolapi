package tech.devinhouse.labschoolapi.web;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AlunoRequest {

    @NotEmpty(message = "(campo.obrigatorio)")
    private String nome;

    @NotEmpty(message = "(campo.obrigatorio)")
    private String telefone;

    @NotNull(message = "(campo.obrigatorio)")
    private LocalDate dataNascimento;

    @NotNull(message = "(campo.obrigatorio)")
    private Long cpf;

    @NotEmpty(message = "(campo.obrigatorio)")
    private String situacao;

    @NotNull(message = "(campo.obrigatorio)")
    private Float nota;

}


