package dev.bearded.challenge01.model.dto;

import dev.bearded.challenge01.model.Video;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VideoDTO(Long id,
		@NotNull(message = "titulo nao pode ser nulo") @NotBlank(message = "titulo nao pode ser em branco") String titulo,
		@NotNull(message = "descricao nao pode ser nulo") @NotBlank(message = "descricao nao pode ser em branco") String descricao,
		@NotNull(message = "url nao pode ser nulo") @NotBlank(message = "url nao pode ser em branco") String url) {

	public VideoDTO(Video video) {
		this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
	}

}
