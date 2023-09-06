package dev.bearded.challenge01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bearded.challenge01.model.dto.VideoDTO;
import dev.bearded.challenge01.service.VideoService;

@RestController
@RequestMapping("video")
public class VideoController {

	private VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("videos")
	public ResponseEntity<List<VideoDTO>> getAllVideos() {
		return ResponseEntity.ok(videoService.getAllVideos());
	}

	@GetMapping("videos/{id}")
	public ResponseEntity<VideoDTO> getVideoById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(videoService.getVideoById(id));
	}
	
	@PostMapping("videos")
	public ResponseEntity<VideoDTO> saveNewVideo(@RequestBody VideoDTO video) {
		return null;
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> errorTreat() {
		return ResponseEntity.status(404).body("Não encontrado");
	}
	
	

}
