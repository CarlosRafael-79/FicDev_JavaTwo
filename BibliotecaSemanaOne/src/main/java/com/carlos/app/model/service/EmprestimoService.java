package com.carlos.app.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Emprestimo;
import com.carlos.app.model.repository.EmprestimoRepository;



@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;

	// Método para retornar todos os Emprestimos
	
	public Emprestimo getLivro(int id) {
		return emprestimoRepository.findById(id).get();
	}
	
	public List<Emprestimo> getAllEmprestimos() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimoRepository.findAll().forEach(emprestimos::add);
		return emprestimos;
	}
	
	public void addEmprestimo(Emprestimo emprestimo) {
		emprestimoRepository.save(emprestimo);
	}
	
	public void updateEmprestimo(Emprestimo emprestimo, int id) {
		Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
		if(optionalEmprestimo.isPresent()) {
			Emprestimo atualizado = optionalEmprestimo.get();
			atualizado.setDataEmprestimo(emprestimo.getDataEmprestimo());
			atualizado.setDataDevolucao(emprestimo.getDataDevolucao());
			atualizado.setDataDevolucaoPrevista(emprestimo.getDataDevolucaoPrevista());
			atualizado.setLivro(emprestimo.getLivro());;
			atualizado.setUsuario(emprestimo.getUsuario());;
			emprestimoRepository.save(atualizado);
		}
	}
	
	public void deleteEmprestimo(int id) {
		emprestimoRepository.deleteById(id);
	}
	

}