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

import br.com.nolapi.domain.Jornalista;
import br.com.nolapi.service.JornalistaService;

@RestController
@RequestMapping("/jornalistas")
public class JornalistaResource {
	@Autowired
	private JornalistaService jornalistaService;
	
	@GetMapping
	public List<Jornalista> listar() {
		return this.jornalistaService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Jornalista> pesquisarPorId(@PathVariable("id") Long id) {
		return this.jornalistaService.pesqusarPorId(id)
				.map(jornalista -> ResponseEntity.ok(jornalista))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Jornalista> salvar(@Validated @RequestBody Jornalista jornalista) {
		Jornalista salvarJornalista = this.jornalistaService.salvar(jornalista);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salvarJornalista.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Jornalista atualizar(@Validated @RequestBody Jornalista jornalista) {
		return this.jornalistaService.atualizar(jornalista);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Jornalista jornalista) {
		this.jornalistaService.remover(jornalista);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.jornalistaService.removerPorId(id);
	}
}
