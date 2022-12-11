package tech.devinhouse.labschoolapi.web;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SituacaoRequest {
    @NotEmpty(message = "(campo.obrigatorio)")
    private String situacao;
}
