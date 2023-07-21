package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Nota;
import com.carlos.app.model.repository.NotaRepository;

@Service
public class NotaService {
	
	@Autowired
	private NotaRepository notaRepository;
	
	public List<Nota> getAllNotas(){
		return notaRepository.findAll();
	}
	
	public Nota getNota(Integer id) {
		return notaRepository.findById(id);
	}
	
	public void saveNota(Nota nota) {
		notaRepository.save(nota);
	}
	
	public void updateNota(Nota nota, int id) throws NotFoundException {
		Nota atualizado = notaRepository.findById(id).orElseThrow(() -> new NotFoundException());
		atualizado.setCnpjFornecedor(atualizado.getCnpjFornecedor());
		atualizado.setData(atualizado.getData());
		atualizado.setValor(atualizado.getValor());
		notaRepository.save(atualizado);
	}
	
	public void deleteNota(int id) throws NotFoundException {
		Nota deletado = notaRepository.findById(id).orElseThrow(()-> new NotFoundException());
		notaRepository.delete(deletado);
	}
}
