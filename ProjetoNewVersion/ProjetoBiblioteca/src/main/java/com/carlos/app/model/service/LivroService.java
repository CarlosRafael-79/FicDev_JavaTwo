package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Livro;
import com.carlos.app.model.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livro getLivro(int id) throws NotFoundException {
		return livroRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public void saveLivro(Livro livro) {
		livroRepository.save(livro);
	}
	

	public Livro updateLivro(Livro livro, int id) throws NotFoundException {
		Livro atualizado = livroRepository.findById(id).orElseThrow(() -> new NotFoundException());
		
		atualizado.setTitulo(livro.getTitulo());
		atualizado.setAutor(livro.getAutor());
		atualizado.setAnoPublicacao(livro.getAnoPublicacao());
		atualizado.setDisponivel(livro.getDisponivel());
		
		livroRepository.save(atualizado);
		return atualizado;
	}
	
	public Livro deleteLivro(int id) throws NotFoundException {
		Livro deletado = livroRepository.findById(id).orElseThrow(()-> new NotFoundException());
		livroRepository.delete(deletado);
		return deletado;
	}
}
