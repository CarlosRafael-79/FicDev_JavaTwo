package com.carlos.app.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.app.model.entity.Emprestimo;
import com.carlos.app.model.service.EmprestimoService;
import com.carlos.app.model.service.LivroService;
import com.carlos.app.model.service.UsuarioService;

@Controller
@RequestMapping("/emprestimo/view")
public class EmprestimoControllerView {

	@Autowired
	EmprestimoService emprestimoService;
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ModelAndView listaEmprestimos() {
		var view = new ModelAndView("listaEmprestimo");
		view.addObject("emprestimos", emprestimoService.getAllEmprestimos());
		return view;
	}
	
	@GetMapping("/remover/{id}")
    public String removerEmprestimo(@PathVariable("id") int id) throws NotFoundException {
		emprestimoService.deleteEmprestimo(id);
        return "redirect:/emprestimo/view/listar";
    }
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarEmprestimo() {
		var view = new ModelAndView("cadastroEmprestimo");
		view.addObject("emprestimo", new Emprestimo());
		view.addObject("livros", livroService.getAllLivros());
		view.addObject("usuarios", usuarioService.getAllUsuarios());
		return view;
	}
	
	@PostMapping("/cadastrar")
	public String saveEmprestimo(Emprestimo emprestimo) {
		emprestimoService.saveEmprestimo(emprestimo);
		ModelAndView modelAndView = new ModelAndView("cadastroEmprestimo");
		modelAndView.addObject("mensagem", "Salvo com sucesso!");
		return "redirect:/emprestimo/view/listar";
	}
	
	@GetMapping("/atualizar/{id}")
	public ModelAndView formUpdate(@PathVariable("id") int id) throws NotFoundException {
		ModelAndView modelAndView = new ModelAndView("cadastroEmprestimo");
		Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
		modelAndView.addObject("emprestimo", emprestimo);
		return modelAndView;
	}
}
