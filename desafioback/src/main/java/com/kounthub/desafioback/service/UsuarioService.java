package com.kounthub.desafioback.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kounthub.desafioback.models.Usuario;

@Service
public class UsuarioService {
	public Usuario getUsuario(String nome) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Usuario> pessoaEntity = null;
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		// Realiza a requisição
		pessoaEntity = restTemplate.exchange(
				"https://api.github.com/users/{user}", 
				HttpMethod.GET, 
				entity, 
				Usuario.class,
				nome
			);
		Usuario usuario = pessoaEntity.getBody();
		
		return usuario;
	}
}
