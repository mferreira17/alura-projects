package dev.bearded.challenge01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.bearded.challenge01.model.dto.VideoDTO;
import dev.bearded.challenge01.repository.VideoRepository;

@Service
public class VideoService {

	private VideoRepository videoRepository;

	public VideoService(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public List<VideoDTO> getAllVideos() {

		return videoRepository.findAll().stream()
				.map(v -> new VideoDTO(v.getId(), v.getTitulo(), v.getDescricao(), v.getUrl())).toList();
	}

	public VideoDTO getVideoById(Long id) {
		return videoRepository.findById(id)
				.map(video -> new VideoDTO(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl()))
				.orElseThrow();
	}

}
