package br.com.alura.forum.controller.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class TokenDto {
    private String access_token;
    private String type;
    private Date expiration;

    public TokenDto(String access_token, Date expiration, String type) {
        this.access_token = access_token;
        this.expiration = expiration;
        this.type = type;
    }
}
