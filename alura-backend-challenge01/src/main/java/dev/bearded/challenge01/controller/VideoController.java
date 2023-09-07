package dev.bearded.challenge01.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bearded.challenge01.model.dto.VideoDTO;
import dev.bearded.challenge01.service.VideoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("video")
public class VideoController {

	private VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping({ "videos", "videos/{id}" })
	public ResponseEntity<?> getAllVideos(@PathVariable(name = "id", required = false) Long id) {
		return id != null ? ResponseEntity.ok(videoService.getVideoById(id))
				: ResponseEntity.ok(videoService.getAllVideos());
	}

	@PostMapping("videos")
	public ResponseEntity<VideoDTO> saveNewVideo(@RequestBody @Valid VideoDTO video) {
		return ResponseEntity.ok(videoService.saveVideo(video));
	}
	
	@PutMapping("videos")
	public ResponseEntity<VideoDTO> updateVideo(@RequestBody @Valid VideoDTO video) throws URISyntaxException{
		return ResponseEntity.created(new URI("/video/videos/"+video.id())).body(videoService.saveVideo(video));
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> notFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
	}

}
