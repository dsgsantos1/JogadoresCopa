package com.example.lp4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lp4.repository.JogadorRepository;

public class HomeController {
	
	JogadorRepository jogadorRepository;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("jogadores", jogadorRepository.findAll());
		return "index";
	}
	
}
