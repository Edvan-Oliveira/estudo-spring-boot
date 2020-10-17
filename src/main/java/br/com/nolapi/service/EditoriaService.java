package br.com.nolapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nolapi.domain.Editoria;
import br.com.nolapi.repository.EditoriaRepository;

@Service
public class EditoriaService {
	@Autowired
	private EditoriaRepository editoriaRepository;
	
	public Editoria salvar(Editoria editoria) {
		return this.editoriaRepository.save(editoria);
	}
	
	public Editoria atualizar(Editoria editoria) {
		return this.editoriaRepository.save(editoria);
	}
	
	public List<Editoria> listar(){
		return this.editoriaRepository.findAll();
	}
	
	public Optional<Editoria> pesquisarPorId(Long id){
		return this.editoriaRepository.findById(id);
	}
	
	public void remover(Editoria editoria) {
		this.editoriaRepository.delete(editoria);
	}
	
	public void removerPorId(Long id) {
		this.editoriaRepository.deleteById(id);
	}
}
