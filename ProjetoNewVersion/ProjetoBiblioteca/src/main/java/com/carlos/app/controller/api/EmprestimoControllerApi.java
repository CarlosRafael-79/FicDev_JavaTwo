package com.carlos.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.app.model.entity.Emprestimo;
import com.carlos.app.model.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimo/api")
public class EmprestimoControllerApi {

	@Autowired
	EmprestimoService emprestimoService;
	
	@GetMapping
	public List<Emprestimo> listarEmprestimos() {
		return emprestimoService.getAllEmprestimos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> listarEmprestimo(@PathVariable int id){
		try {
			Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
			return ResponseEntity.ok(emprestimo);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void cadastrarEmprestimo(@RequestBody Emprestimo emprestimo) {
		emprestimoService.saveEmprestimo(emprestimo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> updateEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo) {
		try {
			Emprestimo atualizado = emprestimoService.updateEmprestimo(emprestimo, id);
			return ResponseEntity.ok(atualizado);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Emprestimo> deleteEmprestimo(@PathVariable int id){
		try {
			Emprestimo emprestimo = emprestimoService.deleteEmprestimo(id);
			return ResponseEntity.ok(emprestimo);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
