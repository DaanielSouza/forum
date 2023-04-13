package br.com.alura.forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class Validacao {
    @Autowired
    private MessageSource message;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDto> handle(MethodArgumentNotValidException e) {
        List<ErroFormularioDto> lista = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((erro) -> {
            lista.add(
                    new ErroFormularioDto(erro.getField(),
                            message.getMessage(erro, LocaleContextHolder.getLocale())));
        });

        return lista;
    }

}
