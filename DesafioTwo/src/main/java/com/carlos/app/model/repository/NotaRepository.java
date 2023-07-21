package com.carlos.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carlos.app.model.entity.Nota;

@EnableJpaRepositories
public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
