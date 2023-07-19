package com.carlos.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.app.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
