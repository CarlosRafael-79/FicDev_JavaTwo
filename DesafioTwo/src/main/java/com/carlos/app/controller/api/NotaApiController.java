package com.carlos.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.app.model.entity.Nota;


@RestController
@RequestMapping("/nota/api")
public class NotaApiController {
	@Autowired
	
	NotaService notaService;

	@GetMapping
	public List<Nota> listarNotas() {
		return notaService.getAllNotas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Nota> listarNota(@PathVariable int id) {
		try {
			Nota nota = notaService.getNota(id);
			return ResponseEntity.ok(nota);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Nota cadastrarNota(@RequestBody Nota nota) {
		return notaService.saveNota(nota);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Nota> updateNota(@PathVariable int id, @RequestBody Nota nota) {
		try {
			Nota atualizado = notaService.updateNota(nota, id);
			return ResponseEntity.ok(atualizado);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Nota> deleteNota(@PathVariable int id) {
		try {
			Nota Nota = NotaService.deleteNota(id);
			return ResponseEntity.ok(Nota);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
