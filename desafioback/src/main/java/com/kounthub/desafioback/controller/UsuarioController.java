package com.kounthub.desafioback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kounthub.desafioback.models.Usuario;
import com.kounthub.desafioback.service.UsuarioService;

@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public Usuario getUsuario(@RequestParam String nome) {
		Usuario usuario = usuarioService.getUsuario(nome);
		return usuario;
	}
}
