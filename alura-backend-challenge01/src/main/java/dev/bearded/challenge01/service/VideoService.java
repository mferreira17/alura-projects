package dev.bearded.challenge01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.bearded.challenge01.model.Video;
import dev.bearded.challenge01.model.dto.VideoDTO;
import dev.bearded.challenge01.repository.VideoRepository;

@Service
public class VideoService {

	private VideoRepository videoRepository;

	public VideoService(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public List<VideoDTO> getAllVideos() {
		return videoRepository.findAll().stream().map(VideoDTO::new).toList();
	}

	public VideoDTO getVideoById(Long id) {
		return videoRepository.findById(id).map(VideoDTO::new).orElseThrow();
	}

	public VideoDTO saveVideo(VideoDTO video) {
		if(video.id() != null) {
			Video updatedVideo = videoRepository.save(new Video(video.id(), video.titulo(), video.descricao(), video.url()));
			return new VideoDTO(updatedVideo);
		}
		Video newVideo = videoRepository.save(new Video(video.titulo(), video.descricao(), video.titulo()));
		return new VideoDTO(newVideo);
		
	}

}
