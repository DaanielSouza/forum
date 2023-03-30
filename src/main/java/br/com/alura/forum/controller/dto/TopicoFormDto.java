package br.com.alura.forum.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class TopicoFormDto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @NotBlank
    private String nomeCurso;

    public TopicoFormDto(String titulo, String mensagem, String nomeCurso){
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }
}
