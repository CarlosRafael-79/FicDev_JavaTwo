package com.carlos.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.Nutricionista;
import com.carlos.app.repository.NutricionistaRepository;

@Service
public class NutricionistaService {
	
	@Autowired
	NutricionistaRepository nutricionistaRepository;
	
	public List<Nutricionista> getAllNutricionistas(){
		return nutricionistaRepository.findAll();
	}
	
	public Nutricionista getNutricionista(int id) throws NotFoundException {
		return nutricionistaRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	
	public Nutricionista deleteNutricionista(int id) throws NotFoundException {
		Nutricionista deletado = nutricionistaRepository.findById(id).orElseThrow(()-> new NotFoundException());
		nutricionistaRepository.delete(deletado);
		return deletado;
	}
	
}
