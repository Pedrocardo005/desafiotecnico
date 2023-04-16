package com.kounthub.desafioback.models;

import java.util.ArrayList;

public class Usuario {
	private String login;
	
	private ArrayList<Repositorio> repositorios;
	
	public Usuario () {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public ArrayList<Repositorio> getRepositorios() {
		return repositorios;
	}

	public void setRepositorios(ArrayList<Repositorio> repositorios) {
		this.repositorios = repositorios;
	}
}
