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

import com.carlos.app.model.entity.Usuario;
import com.carlos.app.model.service.UsuarioService;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listarTodosUsuarios(){
		return usuarioService.getAllUsuarios();
	}
	
	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		usuarioService.addUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public void updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
		usuarioService.updateUsuario(usuario, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable int id) {
		usuarioService.deleteUsuario(id);
	}
	

}
