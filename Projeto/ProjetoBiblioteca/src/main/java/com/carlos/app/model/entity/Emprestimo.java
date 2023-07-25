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
	public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataRealDevolucao,
			Usuario usuario, Livro livro) {
		super();
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.dataRealDevolucao = dataRealDevolucao;
		this.usuario = usuario;
		this.livro = livro;
	}
	public Emprestimo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	public LocalDate getDataRealDevolucao() {
		return dataRealDevolucao;
	}
	public void setDataRealDevolucao(LocalDate dataRealDevolucao) {
		this.dataRealDevolucao = dataRealDevolucao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
