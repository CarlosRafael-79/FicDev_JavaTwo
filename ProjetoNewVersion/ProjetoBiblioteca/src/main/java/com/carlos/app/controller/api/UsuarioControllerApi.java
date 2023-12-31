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

import com.carlos.app.model.entity.Usuario;
import com.carlos.app.model.service.UsuarioService;

@RestController
@RequestMapping("/usuario/api")
public class UsuarioControllerApi {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarUsuario(@PathVariable int id){
		try {
			Usuario usuario = usuarioService.getUsuario(id);
			return ResponseEntity.ok(usuario);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		usuarioService.saveUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
		try {
			Usuario atualizado = usuarioService.updateUsuario(usuario, id);
			return ResponseEntity.ok(atualizado);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable int id){
		try {
			Usuario usuario = usuarioService.deleteUsuario(id);
			return ResponseEntity.ok(usuario);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
