package br.com.nolapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nolapi.domain.Jornalista;
import br.com.nolapi.repository.JornalistaRepository;

@Service
public class JornalistaService {
	@Autowired
	private JornalistaRepository jornalistaRepository;
	
	public Jornalista salvar(Jornalista jornalista) {
		return this.jornalistaRepository.save(jornalista);
	}
	
	public Jornalista atualizar(Jornalista jornalista) {
		return this.jornalistaRepository.save(jornalista);
	}
	
	public List<Jornalista> listar() {
		return this.jornalistaRepository.findAll();
	}
	
	public Optional<Jornalista> pesqusarPorId(Long id) {
		return this.jornalistaRepository.findById(id);
	}
	
	public List<Jornalista> pesquisarPorNome(String nome) {
		return this.jornalistaRepository.findByNomeOrderByNome(nome);
	}
	
	public List<Jornalista> pesquisarPorEmailContendo(String email) {
		return this.jornalistaRepository.findByEmailContaining(email);
	}
	
	public List<Jornalista> listarTodosComecadosPorA() {
		return this.jornalistaRepository.listarTodosComecadosPorA();
	}
	
	public List<Jornalista> listarTudo() {
		return this.jornalistaRepository.listarTudo();
	}
	
	public List<Jornalista> listarQuemTemNoticiaNaEditoria(String nomeEditoria) {
		return this.jornalistaRepository.listarQuemTemNoticiaNaEditoria(nomeEditoria);
	}
	
	public void remover(Jornalista jornalista) {
		this.jornalistaRepository.delete(jornalista);
	}
	
	public void removerPorId(Long id) {
		this.jornalistaRepository.deleteById(id);
	}
}