package com.carlos.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Nutricionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nomenutricionista", nullable = false, columnDefinition= "TEXT")
	private String nome;
	@Column(nullable = false, columnDefinition= "TEXT")
	private String crn;
	@Column(nullable = false, columnDefinition= "TEXT")
	private String uf;
	
}
