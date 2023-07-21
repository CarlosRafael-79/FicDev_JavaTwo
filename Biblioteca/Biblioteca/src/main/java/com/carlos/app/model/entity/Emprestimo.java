package com.carlos.app.model.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Emprestimo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate dataEmprestimo;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate dataPrevistaDevolucao;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate dataRealDevolucao;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	@JsonIgnore
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="id_livro")
	private Livro livro;
}
