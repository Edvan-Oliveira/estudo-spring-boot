package br.com.nolapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Editoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome da editoria é obrigatório!")
	@Size(min = 5, max = 50, message = "O nome da editoria deve conter no mínimo {min} caracteres e no máximo {max}")
	private String nome;
	
	@NotNull(message = "A lista de notícias pode ser vazia mas não pode ser nula!")
	@OneToMany(mappedBy = "editoria")
	private List<Noticia> noticias;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
