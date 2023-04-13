package br.com.alura.forum.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AtualizacaoTopicoFormDto {
    @NotBlank @Length(min = 5)
    private String titulo;
    @NotBlank @Length(min = 5)
    private String mensagem;
}
