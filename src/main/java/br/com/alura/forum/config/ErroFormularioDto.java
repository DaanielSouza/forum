package br.com.alura.forum.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroFormularioDto {
    private String campo;

    private String mensagem;
}
