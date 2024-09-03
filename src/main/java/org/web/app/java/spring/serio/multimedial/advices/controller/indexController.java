package org.web.app.java.spring.serio.multimedial.advices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.app.java.spring.serio.multimedial.advices.repository.MovieRepository;
import org.web.app.java.spring.serio.multimedial.advices.repository.SongRepository;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	public SongRepository songRepo;
	@Autowired
	public MovieRepository movieRepo;

	@GetMapping()
	public String home(Model model) {

		model.addAttribute("title", "Home");

		return "/pages/home";
	}

}
