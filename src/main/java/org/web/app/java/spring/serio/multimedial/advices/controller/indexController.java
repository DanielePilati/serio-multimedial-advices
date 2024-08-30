package org.web.app.java.spring.serio.multimedial.advices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

	@GetMapping()
	public String home(Model model) {
		
		model.addAttribute("title", "Home");
		
		return "/pages/home";
	}
		
	
}
