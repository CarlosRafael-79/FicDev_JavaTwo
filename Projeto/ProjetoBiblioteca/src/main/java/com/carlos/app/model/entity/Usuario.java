package com.carlos.app.model.entity;

import com.carlos.app.controller.security.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String nome;

	private String telefone;

	private String senha;

	private String email;

	private int quantidadeEmprestimo;
	
	private UserRole role = UserRole.USER;

	public Usuario(int id, String nome, String telefone, String senha, String email, int quantidadeEmprestimo,
			UserRole role) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		this.email = email;
		this.quantidadeEmprestimo = quantidadeEmprestimo;
		this.role = role;
	}

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuantidadeEmprestimo() {
		return quantidadeEmprestimo;
	}

	public void setQuantidadeEmprestimo(int quantidadeEmprestimo) {
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	
	
}
