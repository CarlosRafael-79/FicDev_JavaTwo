package com.carlos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.app.model.entity.Livro;
import com.carlos.app.model.service.LivroService;




@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping
	public List<Livro> listarTodosLivros(){
		return livroService.getAllLivros();
	}
	
	@PostMapping
	public void cadastrarLivro(@RequestBody Livro livro) {
		livroService.addLivro(livro);
	}
	
	@PutMapping("/{id}")
	public void updateLivro(@PathVariable int id, @RequestBody Livro livro) {
		livroService.updateLivro(livro, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable int id) {
		livroService.deleteLivro(id);
	}
	

}
