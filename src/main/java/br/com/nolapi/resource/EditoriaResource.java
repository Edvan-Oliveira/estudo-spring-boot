package br.com.nolapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nolapi.domain.Editoria;
import br.com.nolapi.service.EditoriaService;

@RestController
@RequestMapping("/editorias")
public class EditoriaResource {
	@Autowired
	private EditoriaService editoriaService;
	
	@GetMapping
	public List<Editoria> listar() {
		return editoriaService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Editoria> pesquisarPorId(@PathVariable("id") Long id) {
		return this.editoriaService.pesquisarPorId(id)
				.map(editoria -> ResponseEntity.ok(editoria))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(params = "nome")
	public List<Editoria> pesquisarPorNome(@RequestParam String nome) {
		return this.editoriaService.pesquisarPorNome(nome);
	}
	
	@GetMapping("/comecadaspore")
	public List<Editoria> listarTodasComecadasPorE() {
		return this.editoriaService.listarTodasComecadasPorE();
	}
	
	@PostMapping
	public ResponseEntity<Editoria> salvar(@Validated @RequestBody Editoria editoria) {
		Editoria salvarEditoria = this.editoriaService.salvar(editoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salvarEditoria.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Editoria atualizar(@Validated @RequestBody Editoria editoria) {
		return this.editoriaService.atualizar(editoria);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Editoria editoria) {
		this.editoriaService.remover(editoria);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.editoriaService.removerPorId(id);
	}
}
