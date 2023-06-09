package com.kounthub.desafioback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.kounthub.desafioback.models.Falha;
import com.kounthub.desafioback.models.Usuario;
import com.kounthub.desafioback.service.UsuarioService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity getUsuario(@RequestParam String nome) {
		try {
			Usuario usuario = usuarioService.getUsuario(nome);
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		} catch (RestClientException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Falha("Usuário não encontrado"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Falha("Ocorreu algum erro interno"));
		}
	}
}
