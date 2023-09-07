package dev.bearded.challenge01.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;

	private String descricao;

	private String url;

	public Video() {
	}

	public Video(Long id, String titulo, String descricao, String url) {
		this(titulo, descricao, url);
		this.id = id;
	}

	public Video(String titulo, String descricao, String url) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(url, other.url);
	}

}
