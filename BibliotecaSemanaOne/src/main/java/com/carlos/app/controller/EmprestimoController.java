package com.carlos.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.carlos.app.model.service.LivroService;
import com.carlos.app.model.service.UsuarioService;



@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	@Autowired
	EmprestimoService emprestimoService;
	@Autowired
	LivroService livroService;
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Emprestimo> listarTodosEmprestimos(){
		return emprestimoService.getAllEmprestimos();
	}
	
	@PostMapping("/{idLivro}/{idUsuario}")
	public void cadastrarEmprestimo(@RequestBody Emprestimo emprestimo, @PathVariable int idLivro, @PathVariable int idUsuario) {
		emprestimo.setLivro(livroService.getLivro(idLivro));
		emprestimo.setUsuario(usuarioService.getUsuario(idUsuario));
		emprestimoService.addEmprestimo(emprestimo);
	}
	
	@PutMapping("/{id}")
	public void updateEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo) {
		emprestimoService.updateEmprestimo(emprestimo, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmprestimo(@PathVariable int id) {
		emprestimoService.deleteEmprestimo(id);
	}
	

}
