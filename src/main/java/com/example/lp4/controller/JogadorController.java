package com.example.lp4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lp4.repository.JogadorRepository;
import com.example.lp4.orm.Jogador;

@Controller
public class JogadorController {
	
	@Autowired
	JogadorRepository jogadorRepository;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("jogadores", jogadorRepository.findAll());
		return "index";
	}

	@GetMapping("/listar")
	public String listarJogadores(Model model) {
		model.addAttribute("jogadores", jogadorRepository.findAll());
		return "jogadores";
	}
	
	@GetMapping("/adicionar")
	public String adicionarJogador(Model model) {
		model.addAttribute("jogador", new Jogador());
		return ("formJogador");
	}
	
	@PostMapping("/salvar")
	public String salvarJogador(@Valid Jogador jogador, BindingResult result) {
		if(result.hasErrors()) {
			return "formJogador";
		}
		jogadorRepository.save(jogador);
		return "redirect:/";
	}

}
