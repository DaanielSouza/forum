package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto(Resposta resp){
        this.id = resp.getId();
        this.mensagem = resp.getMensagem();
        this.dataCriacao = resp.getDataCriacao();
        this.nomeAutor = resp.getAutor().getNome();
    }

}
