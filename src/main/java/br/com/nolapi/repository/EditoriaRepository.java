package br.com.nolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.nolapi.domain.Editoria;

@Repository
public interface EditoriaRepository extends JpaRepository<Editoria, Long> {
	public List<Editoria> findByNomeOrderByNomeAsc(String nome);
	
	@Query("SELECT e FROM Editoria e WHERE e.nome LIKE 'E%'")
	public List<Editoria> listarTodasComecandasPorE();
}
