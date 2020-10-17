package br.com.nolapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Jornalista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O nome do jornalista é obrigatório!")
	@Size(min = 5, max = 50, message = "O nome do jornalista deve conter no mínimo {min} caracteres e no máximo {max}")
	private String nome;
	
	@NotEmpty(message = "O email do jornalista é obrigatório!")
	@Size(min = 5, max = 50, message = "O email do jornalista deve conter no mínimo {min} caracteres e no máximo {max}")
	@Email(message = "Informe um email valido")
	private String email;
	
	@NotEmpty(message = "A biografia do jornalista é obrigatório!")
	@Size(min = 10, max = 100, message = "A biografia do jornalista deve conter no mínimo {min} caracteres e no máximo {max}")
	private String biografia;
	
	@NotNull(message = "A lista de notícias pode ser vazia mas não pode ser nula!")
	@JsonIgnoreProperties("jornalistas")
	@ManyToMany(mappedBy = "jornalistas")
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}	
}
