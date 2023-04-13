package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.AtualizacaoTopicoFormDto;
import br.com.alura.forum.controller.dto.TopicoFormDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.com.alura.forum.controller.dto.TopicoDto;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Cacheable(value = "listaTopicos")
    @GetMapping
    public ResponseEntity<Page<TopicoDto>> lista(@PageableDefault Pageable pageable, String nomeCurso) {
        if (nomeCurso == null) {
            return ResponseEntity.ok().body(TopicoDto.converter(topicoRepository.findAll(pageable)));
        }

        return ResponseEntity.ok().body(TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso, pageable)));
    }

    @PostMapping
    @ResponseBody
    @Transactional
    public ResponseEntity<TopicoDto> lista(@Valid @RequestBody TopicoFormDto body, UriComponentsBuilder uriComponentsBuilder) {
        Optional<Curso> curso = cursoRepository.findByNome(body.getNomeCurso());
        Optional<Usuario> user = usuarioRepository.findById(1L);

        if (curso.isPresent() && user.isPresent()) {
            Topico topico = new Topico(body, curso.get(), user.get());
            topicoRepository.save(topico);
            URI uri = uriComponentsBuilder.path("/topicos/" + topico.getId().toString()).build().toUri();
            return ResponseEntity.created(uri).body(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TopicoDto> buscaPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        return topico.map(value -> ResponseEntity.ok().body(new TopicoDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id,
                                               @RequestBody @Valid AtualizacaoTopicoFormDto body) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topico.get().atualizarTopico(body);
            return ResponseEntity.ok().body(new TopicoDto(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
