package org.web.app.java.spring.serio.multimedial.advices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.app.java.spring.serio.multimedial.advices.model.Movie;
import org.web.app.java.spring.serio.multimedial.advices.repository.MovieRepository;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	public MovieRepository repo;

	@GetMapping()
	public String index(Model model) {

		List<Movie> movies = repo.findAll();
		model.addAttribute("movies", movies);
		model.addAttribute("title", "Movies");

		return "/movies/index";
	}
		
	@GetMapping("/movieinfo/{id}")
	public String movieInfo(Model model, @PathVariable("id") Integer id) {

		model.addAttribute("movie", repo.findById(id).get());
		model.addAttribute("title", repo.findById(id).get().getTitle());

		return "/movies/movieinfo";
	}
	

}
