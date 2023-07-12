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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, nullable = false)
	private String titulo;
	@Column(length = 100, nullable = false, unique = true)
	private String autor;
	@Column(nullable = false, precision = 4, scale = 0)
	private int anoPublicacao;
	private boolean disponivel;
	@OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Emprestimo> emprestimo = new HashSet<Emprestimo>();


}
