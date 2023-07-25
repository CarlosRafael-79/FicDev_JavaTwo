package com.carlos.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/livro/api")
public class LivroControllerApi {

	@Autowired
	LivroService livroService;
	
	@GetMapping
	public List<Livro> listarLivros() {
		return livroService.getAllLivros();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> listarLivro(@PathVariable int id){
		try {
			Livro livro = livroService.getLivro(id);
			return ResponseEntity.ok(livro);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void cadastrarLivro(@RequestBody Livro livro) {
		livroService.saveLivro(livro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> updateLivro(@PathVariable int id, @RequestBody Livro livro) {
		try {
			Livro atualizado = livroService.updateLivro(livro, id);
			return ResponseEntity.ok(atualizado);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deleteLivro(@PathVariable int id){
		try {
			Livro livro = livroService.deleteLivro(id);
			return ResponseEntity.ok(livro);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
