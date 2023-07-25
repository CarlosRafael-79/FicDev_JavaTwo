package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Emprestimo;
import com.carlos.app.model.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public List<Emprestimo> getAllEmprestimos(){
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo getEmprestimo(int id) throws NotFoundException {
		return emprestimoRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public void saveEmprestimo(Emprestimo emprestimo) {
		emprestimoRepository.save(emprestimo);
	}
	

	public Emprestimo updateEmprestimo(Emprestimo emprestimo, int id) throws NotFoundException {
		Emprestimo atualizado = emprestimoRepository.findById(id).orElseThrow(() -> new NotFoundException());
		
		atualizado.setDataEmprestimo(emprestimo.getDataEmprestimo());
		atualizado.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
		atualizado.setDataRealDevolucao(emprestimo.getDataRealDevolucao());
		atualizado.setLivro(emprestimo.getLivro());
		atualizado.setUsuario(emprestimo.getUsuario());
		
		emprestimoRepository.save(atualizado);
		return atualizado;
	}
	
	public Emprestimo deleteEmprestimo(int id) throws NotFoundException {
		Emprestimo deletado = emprestimoRepository.findById(id).orElseThrow(()-> new NotFoundException());
		emprestimoRepository.delete(deletado);
		return deletado;
	}
}
