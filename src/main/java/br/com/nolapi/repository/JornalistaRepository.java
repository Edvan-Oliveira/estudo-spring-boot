package br.com.nolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nolapi.domain.Jornalista;

@Repository
public interface JornalistaRepository extends JpaRepository<Jornalista, Long> {

}
