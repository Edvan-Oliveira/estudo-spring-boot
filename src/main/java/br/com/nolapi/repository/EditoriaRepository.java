package br.com.nolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nolapi.domain.Editoria;

@Repository
public interface EditoriaRepository extends JpaRepository<Editoria, Long> {

}
