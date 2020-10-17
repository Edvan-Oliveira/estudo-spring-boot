package br.com.nolapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O titulo da notícia é obrigatório!")
	@Size(min = 5, max = 50, message = "O titulo da notícia deve conter no mínimo {min} caracteres e no máximo {max}")
	private String titulo;
	
	@NotNull(message = "A lista de jornalistas não pode ser nula!")
	@NotEmpty(message = "A notícia é obrigatória conter pelo menos um jornalista!")
	@JsonIgnoreProperties("noticias")
	@ManyToMany
	@JoinTable(
			name = "noticias_jornalistas",
			joinColumns = @JoinColumn(name = "noticia_id"),
			inverseJoinColumns = @JoinColumn(name = "jornalista_id"))
	private List<Jornalista> jornalistas;
	
	@NotNull(message = "A editoria não pode ser nula!")
	@JsonIgnoreProperties("noticias")
	@ManyToOne
	private Editoria editoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Jornalista> getJornalistas() {
		return jornalistas;
	}
	public void setJornalistas(List<Jornalista> jornalistas) {
		this.jornalistas = jornalistas;
	}
	public Editoria getEditoria() {
		return editoria;
	}
	public void setEditoria(Editoria editoria) {
		this.editoria = editoria;
	}
}
