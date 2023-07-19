package com.carlos.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.app.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
