package com.yoona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(path = { "/", "/home" })
	public String home(@RequestParam(name="boardWriter", required = false) String writer, Model model) {
		
//		model.addAttribute("writer", writer);
		return "/home";
	}
}
