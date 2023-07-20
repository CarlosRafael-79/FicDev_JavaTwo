package com.carlos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.app.model.entity.Pessoa;
import com.carlos.app.model.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listarPessoas() {
		return pessoaService.getAllPessoas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listarPessoa(@PathVariable int id){
		try {
			Pessoa Pessoa = pessoaService.getPessoa(id);
			return ResponseEntity.ok(Pessoa);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void cadastrarPessoa(@RequestBody Pessoa pessoa) {
		pessoaService.savePessoa(pessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable int id, @RequestBody Pessoa Pessoa) {
		try {
			Pessoa atualizado = pessoaService.updatePessoa(Pessoa, id);
			return ResponseEntity.ok(atualizado);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> deletePessoa(@PathVariable int id){
		try {
			Pessoa Pessoa = pessoaService.deletePessoa(id);
			return ResponseEntity.ok(Pessoa);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//---------------------------------------------------------------------
	
	@GetMapping("/listar")
	public ModelAndView listaPessoas() {
		var view = new ModelAndView("listaPessoa");
		view.addObject("pessoas", pessoaService.getAllPessoas());
		return view;
	}
	
	@GetMapping("/remover/{id}")
    public String removerPessoa(@PathVariable("id") int id) throws NotFoundException {
		pessoaService.deletePessoa(id);
        return "redirect:/pessoa/listar";
    }
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarPessoa() {
		var view = new ModelAndView("cadastroPessoa");
		view.addObject("pessoa", new Pessoa());
		return view;
	}
	
	@PostMapping("/cadastrar")
	public String saveLivro(Pessoa pessoa) {
		pessoaService.savePessoa(pessoa);
		ModelAndView modelAndView = new ModelAndView("cadastroPessoa");
		modelAndView.addObject("mensagem", "Salvo com sucesso!");
		return "redirect:/pessoa/listar";
	}
	
	@GetMapping("/atualizar/{id}")
	public ModelAndView formUpdate(@PathVariable("id") int id) throws NotFoundException {
		ModelAndView modelAndView = new ModelAndView("cadastroPessoa");
		Pessoa pessoa = pessoaService.getPessoa(id);
		modelAndView.addObject("pessoa", pessoa);
		return modelAndView;
	}
}
