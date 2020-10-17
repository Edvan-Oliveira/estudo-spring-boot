package br.com.nolapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nolapi.domain.Noticia;
import br.com.nolapi.repository.NoticiaRepository;

@Service
public class NoticiaService {
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	public Noticia salvar(Noticia noticia) {
		return this.noticiaRepository.save(noticia);
	}
	
	public Noticia atualizar(Noticia noticia) {
		return this.noticiaRepository.save(noticia);
	}
	
	public List<Noticia> listar() {
		return this.noticiaRepository.findAll();
	}
	
	public Optional<Noticia> pesquisarPorId(Long id) {
		return this.noticiaRepository.findById(id);
	}
	
	public void remover(Noticia noticia) {
		this.noticiaRepository.delete(noticia);
	}
	
	public void removerPorId(Long id) {
		this.noticiaRepository.deleteById(id);
	}
}
