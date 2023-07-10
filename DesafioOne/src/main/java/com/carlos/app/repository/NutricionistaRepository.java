package com.carlos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.carlos.app.model.Nutricionista;

@EnableJpaRepositories
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer> {

}
