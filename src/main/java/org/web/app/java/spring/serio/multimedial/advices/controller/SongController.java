package org.web.app.java.spring.serio.multimedial.advices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.app.java.spring.serio.multimedial.advices.model.Song;
import org.web.app.java.spring.serio.multimedial.advices.repository.SongRepository;

@Controller
@RequestMapping("/songs")
public class SongController {

	@Autowired
	public SongRepository repo;

	@GetMapping()
	public String index(Model model) {

		List<Song> songs = repo.findAll();
		model.addAttribute("songs", songs);
		model.addAttribute("title", "Songs");

		return "/songs/index";
	}	

}
