package org.web.app.java.spring.serio.multimedial.advices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.app.java.spring.serio.multimedial.advices.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
	
	List<Song> findByTitleContainingIgnoreCase(String title);

}
