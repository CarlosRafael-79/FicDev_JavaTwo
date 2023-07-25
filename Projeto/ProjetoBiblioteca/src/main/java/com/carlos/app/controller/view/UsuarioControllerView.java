package com.carlos.app.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.app.model.entity.Usuario;
import com.carlos.app.model.service.UsuarioService;

@Controller
@RequestMapping("/usuario/view")
public class UsuarioControllerView {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ModelAndView listaUsuarios() {
		var view = new ModelAndView("listaUsuario");
		view.addObject("usuarios", usuarioService.getAllUsuarios());
		return view;
	}
	
	@GetMapping("/remover/{id}")
    public String removerUsuario(@PathVariable("id") int id) throws NotFoundException {
		usuarioService.deleteUsuario(id);
        return "redirect:/usuario/view/listar";
    }
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarUsuario() {
		var view = new ModelAndView("cadastroUsuario");
		view.addObject("usuario", new Usuario());
		return view;
	}
	
	@PostMapping("/cadastrar")
	public String saveUsuario(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		ModelAndView modelAndView = new ModelAndView("cadastroUsuario");
		modelAndView.addObject("mensagem", "Salvo com sucesso!");
		return "redirect:/usuario/view/listar";
	}
	
	@GetMapping("/atualizar/{id}")
	public ModelAndView formUpdate(@PathVariable("id") int id) throws NotFoundException {
		ModelAndView modelAndView = new ModelAndView("cadastroUsuario");
		Usuario usuario = usuarioService.getUsuario(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
}
