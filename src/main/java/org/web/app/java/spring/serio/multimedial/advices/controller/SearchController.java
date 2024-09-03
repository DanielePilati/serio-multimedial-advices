package org.web.app.java.spring.serio.multimedial.advices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web.app.java.spring.serio.multimedial.advices.repository.MovieRepository;
import org.web.app.java.spring.serio.multimedial.advices.repository.SongRepository;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	public SongRepository songRepo;
	@Autowired
	public MovieRepository movieRepo;

	@GetMapping("/")
	public String search(Model model, @RequestParam(name = "title") String word) {

		model.addAttribute("title", "Search");
		model.addAttribute("word", word);
		model.addAttribute("movies", movieRepo.findByTitleContainingIgnoreCase(word));
		model.addAttribute("songs", songRepo.findByTitleContainingIgnoreCase(word));

		return "/search/index";
	}
	
	@GetMapping("/show/songs/{word}")
	public String showSongs(Model model, @PathVariable("word") String word) {

		model.addAttribute("title", "Search Songs");
		model.addAttribute("word", word);
		model.addAttribute("songs", songRepo.findByTitleContainingIgnoreCase(word));

		return "/search/songs";
	}
	
	@GetMapping("/show/movies/{word}")
	public String showMovies(Model model, @PathVariable("word") String word) {

		model.addAttribute("title", "Search Movies");
		model.addAttribute("word", word);
		model.addAttribute("movies", movieRepo.findByTitleContainingIgnoreCase(word));

		return "/search/movies";
	}

}