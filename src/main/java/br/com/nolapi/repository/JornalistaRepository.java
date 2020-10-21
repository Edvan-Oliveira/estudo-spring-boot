package br.com.nolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.nolapi.domain.Jornalista;

@Repository
public interface JornalistaRepository extends JpaRepository<Jornalista, Long> {
	public List<Jornalista> findByNomeOrderByNome(String nome);
	public List<Jornalista> findByEmailContaining(String email);
	
	@Query("SELECT j FROM Jornalista j WHERE j.nome LIKE 'A%'")
	public List<Jornalista> listarTodosComecadosPorA();
	
	@Query("SELECT j FROM Jornalista j JOIN j.noticias n JOIN n.editoria")
	public List<Jornalista> listarTudo();
	
	@Query("SELECT j FROM Jornalista j JOIN j.noticias n JOIN n.editoria e WHERE e.nome = :nomeEditoria")
	public List<Jornalista> listarQuemTemNoticiaNaEditoria(@Param("nomeEditoria") String nomeEditoria);
}
