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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nolapi.domain.Noticia;
import br.com.nolapi.service.NoticiaService;

@RestController
@RequestMapping("/noticias")
public class NoticiaResource {
	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping
	public List<Noticia> listar() {
		return this.noticiaService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Noticia> pesqusarPorId(@PathVariable("id") Long id) {
		return this.noticiaService.pesquisarPorId(id)
				.map(noticia -> ResponseEntity.ok(noticia))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Noticia> salvar(@Validated @RequestBody Noticia noticia) {
		Noticia salvarNoticia = this.noticiaService.salvar(noticia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salvarNoticia.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Noticia atualizar(@Validated @RequestBody Noticia noticia) {
		return this.noticiaService.atualizar(noticia);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Noticia noticia) {
		this.noticiaService.remover(noticia);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.noticiaService.removerPorId(id);
	}
}
