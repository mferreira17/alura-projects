package dev.bearded.challenge01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.bearded.challenge01.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {


}
