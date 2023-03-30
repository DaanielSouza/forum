package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long>, PagingAndSortingRepository<Topico, Long> {
    Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable);
}