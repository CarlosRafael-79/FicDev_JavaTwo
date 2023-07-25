package com.carlos.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.app.model.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

}
