package com.kounthub.desafioback.models;

import java.util.ArrayList;

public class Usuario {
private String login;
	
	private String created_at;
	
	private String updated_at;
	
	private ArrayList<Repositorio> repositorios;
	
	public Usuario () {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public ArrayList<Repositorio> getRepositorios() {
		return repositorios;
	}

	public void setRepositorios(ArrayList<Repositorio> repositorios) {
		this.repositorios = repositorios;
	}
}
