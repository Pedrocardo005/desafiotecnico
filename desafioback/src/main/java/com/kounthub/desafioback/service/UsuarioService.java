package com.kounthub.desafioback.service;

import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.kounthub.desafioback.models.Repositorio;
import com.kounthub.desafioback.models.Usuario;

@Service
public class UsuarioService {
	public Usuario getUsuario(String nome) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Usuario> usuarioEntity = null;
		Usuario usuario = null;
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		// Realiza a requisição
		usuarioEntity = restTemplate.exchange(
				"https://api.github.com/users/{user}", 
				HttpMethod.GET,
				entity, 
				Usuario.class,
				nome
			);
		usuario = usuarioEntity.getBody();
		
		if (usuario != null) {
			try {
				ResponseEntity<ArrayList<Repositorio>> responseRepo = 
						restTemplate.exchange(
								"https://api.github.com/users/{user}/repos",
								HttpMethod.GET,
								entity,
								new ParameterizedTypeReference<ArrayList<Repositorio>>() {},
								nome);
				
				ArrayList<Repositorio> repositorios = responseRepo.getBody();
				
				usuario.setRepositorios(repositorios);
			} catch (Exception e) {
				
			}
			
		}
		
		return usuario;
	}
}
