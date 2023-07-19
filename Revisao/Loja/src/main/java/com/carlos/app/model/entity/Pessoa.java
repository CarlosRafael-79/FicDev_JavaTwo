package com.carlos.app.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int idade;

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore
	private List<Pessoa> emprestimo = new ArrayList<>();

	public Pessoa(int id, String nome, int idade, List<Pessoa> emprestimo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.emprestimo = emprestimo;
	}

	public Pessoa() {
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Pessoa> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Pessoa> emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	

}
