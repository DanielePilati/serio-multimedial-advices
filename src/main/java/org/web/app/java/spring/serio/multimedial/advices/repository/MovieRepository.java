package org.web.app.java.spring.serio.multimedial.advices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.app.java.spring.serio.multimedial.advices.model.Movie;

public interface MovieRepository extends JpaRepository <Movie, Integer> {

	List<Movie> findByTitleContainingIgnoreCase(String title);
	
}
