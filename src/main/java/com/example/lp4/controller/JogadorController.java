package com.example.lp4.controller;

import javax.validation.Valid;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lp4.repository.JogadorRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import com.example.lp4.orm.Jogador;

@Controller
@RequestMapping("/jogador")
public class JogadorController {
	
	@Autowired
	JogadorRepository jogadorRepository;
	
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
	
	@GetMapping("/editar/{id}") //botão levar pra outra tela
	public String editarJogador(@PathVariable("id") long id, Model model) {
		Optional<Jogador> jogadorVelho = jogadorRepository.findById(id);
		if (!jogadorVelho.isPresent()) {
            throw new IllegalArgumentException("Jogador não encontrado:" + id);
        } 
		Jogador jogador = jogadorVelho.get();
	    model.addAttribute("jogador", jogador); // lançar o objeto
	    return "/auth/user/user-editar-jogador";
	}
	
	@PostMapping("/editar/{id}")
	public String editarJogador(@PathVariable("id") long id, 
			@Valid Jogador jogador, BindingResult result) {
		if (result.hasErrors()) {
	    	jogador.setId(id);
	        return "/auth/user/user-editar-jogador";
	    }
	    jogadorRepository.save(jogador);
	    return "redirect:/jogador/listar";
	}
	
	@GetMapping("/apagar/{id}")
	public String deleteJogador(@PathVariable("id") long id, Model model) {
		Jogador jogador = jogadorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
		jogadorRepository.delete(jogador);
	    return "redirect:/jogador/listar";
	}

	
}
