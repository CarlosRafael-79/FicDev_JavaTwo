	package com.carlos.app.controller.view;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.app.model.entity.Livro;
import com.carlos.app.model.service.LivroService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Controller
@RequestMapping("/livro/view")
public class LivroControllerView {

	@Autowired
	LivroService livroService;
	
	@Autowired
	private Validator validator;
	
	@GetMapping("/listar")
	public ModelAndView listaLivros() {
		var view = new ModelAndView("listaLivro");
		view.addObject("livros", livroService.getAllLivros());
		return view;
	}
	
	@GetMapping("/remover/{id}")
    public String removerLivro(@PathVariable("id") int id) throws NotFoundException {
		livroService.deleteLivro(id);
        return "redirect:/livro/view/listar";
    }
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarLivro() {
		var view = new ModelAndView("cadastroLivro");
		view.addObject("livro", new Livro());
		return view;
	}
	
	@PostMapping("/cadastrar")
	public String saveLivro(Livro livro) {	
		livroService.saveLivro(livro);
		ModelAndView modelAndView = new ModelAndView("cadastroLivro");
		modelAndView.addObject("mensagem", "Salvo com sucesso!");
		return "redirect:/livro/view/listar";
	}
	
//	@PostMapping("/cadastrar")
//	public ModelAndView saveLivro(Livro livro) {
//		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
//		String problemas = "";
//		String mensagens = "";
//		if (!violations.isEmpty()) {
//			problemas = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
//		} else {
//			livroService.saveLivro(livro);
//			mensagens = "Salvo com sucesso!";
//		}
//		ModelAndView modelAndView = new ModelAndView("cadastroLivro	");
//		modelAndView.addObject("sucesso", mensagens);
//		modelAndView.addObject("error", problemas);
//		return modelAndView;
//	}
	
	@GetMapping("/atualizar/{id}")
	public ModelAndView formUpdate(@PathVariable("id") int id) throws NotFoundException {
		ModelAndView modelAndView = new ModelAndView("cadastroLivro");
		Livro livro = livroService.getLivro(id);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}
	
	
	
}
