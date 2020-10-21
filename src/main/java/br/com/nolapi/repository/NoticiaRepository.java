package br.com.nolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nolapi.domain.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
	public List<Noticia> findByTituloStartingWithOrderByTituloDesc(String titulo);
}
