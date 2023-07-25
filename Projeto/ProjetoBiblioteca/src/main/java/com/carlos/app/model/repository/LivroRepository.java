package com.carlos.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.app.model.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
