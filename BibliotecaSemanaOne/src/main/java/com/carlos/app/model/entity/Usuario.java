package com.carlos.app.model.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false,precision = 4, scale=0)
	private int qtdLivrosEmprestados;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Emprestimo> emprestimo = new HashSet<Emprestimo>();

}
