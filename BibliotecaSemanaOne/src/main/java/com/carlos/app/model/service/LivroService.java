package com.carlos.app.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Livro;
import com.carlos.app.model.repository.LivroRepository;



@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	// Método para retornar todos os livros
	
	public Livro getLivro(int id) {
		return livroRepository.findById(id).get();
	}
	
	public List<Livro> getAllLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		livroRepository.findAll().forEach(livros::add);
		return livros;
	}
	
	public void addLivro(Livro livro) {
		livroRepository.save(livro);
	}
	
	public void updateLivro(Livro livro, int id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		if(optionalLivro.isPresent()) {
			optionalLivro.get().setAutor(livro.getAutor());
			optionalLivro.get().setTitulo(livro.getTitulo());
			optionalLivro.get().setAnoPublicacao(livro.getAnoPublicacao());
			optionalLivro.get().setDisponivel(livro.isDisponivel());
			livroRepository.save(optionalLivro.get());
		}
	}
	
	public void deleteLivro(int id) {
		livroRepository.deleteById(id);
	}

}
