package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Pessoa;
import com.carlos.app.model.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> getAllPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa getPessoa(int id) throws NotFoundException {
		return pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public void savePessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	

	public Pessoa updatePessoa(Pessoa pessoa, int id) throws NotFoundException {
		Pessoa atualizado = pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException());
		
		atualizado.setIdade(pessoa.getIdade());
		atualizado.setNome(pessoa.getNome());
		
		pessoaRepository.save(atualizado);
		return atualizado;
	}
	
	public Pessoa deletePessoa(int id) throws NotFoundException {
		Pessoa deletado = pessoaRepository.findById(id).orElseThrow(()-> new NotFoundException());
		pessoaRepository.delete(deletado);
		return deletado;
	}
}
