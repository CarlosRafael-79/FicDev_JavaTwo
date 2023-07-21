package com.carlos.app.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cnpj_fornecedor", nullable = false, columnDefinition= "TEXT")
	private String cnpjFornecedor;
	@Column(nullable = false, columnDefinition= "date")
	private String data;
	@Column(nullable = false)
	private double valor;
	
	
}
