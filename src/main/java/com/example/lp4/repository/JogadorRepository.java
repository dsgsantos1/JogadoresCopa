package com.example.lp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lp4.orm.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	
}
