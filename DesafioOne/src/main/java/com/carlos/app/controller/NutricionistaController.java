package com.carlos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.app.model.Nutricionista;
import com.carlos.app.service.NutricionistaService;

@RestController
@RequestMapping("/nutricionista/api")
public class NutricionistaController {

	@Autowired
	NutricionistaService nutricionistaService;
	
	@GetMapping
	public List<Nutricionista> listAllUsers() {
		return nutricionistaService.getAllNutricionistas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nutricionista> getUserBydId(@PathVariable int id){
		try {
			Nutricionista nutricionista = nutricionistaService.getNutricionista(id);
			return ResponseEntity.ok(nutricionista);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Nutricionista> deleteLivro(@PathVariable int id){
		try {
			Nutricionista nutricionista = nutricionistaService.deleteNutricionista(id);
			return ResponseEntity.ok(nutricionista);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
