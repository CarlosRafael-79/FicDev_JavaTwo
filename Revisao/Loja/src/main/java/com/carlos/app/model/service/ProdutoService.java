package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Produto;
import com.carlos.app.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto getProduto(int id) throws NotFoundException {
		return produtoRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public void saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	

	public Produto updateLivro(Produto produto, int id) throws NotFoundException {
		Produto atualizado = produtoRepository.findById(id).orElseThrow(() -> new NotFoundException());
		
		atualizado.setValor(produto.getValor());
		atualizado.setNome(produto.getNome());
		
		produtoRepository.save(atualizado);
		return atualizado;
	}
	
	public Produto deleteLivro(int id) throws NotFoundException {
		Produto deletado = produtoRepository.findById(id).orElseThrow(()-> new NotFoundException());
		produtoRepository.delete(deletado);
		return deletado;
	}
}
