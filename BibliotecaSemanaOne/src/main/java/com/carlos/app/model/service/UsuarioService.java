package com.carlos.app.model.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Usuario;
import com.carlos.app.model.repository.UsuarioRepository;
																																																																												


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	// Método para retornar todos os Usuarios
	
	public Usuario getUsuario(int id) {
		return usuarioRepository.findById(id).get();
	}
	
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarioRepository.findAll().forEach(usuarios::add);
		return usuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void updateUsuario(Usuario usuario, int id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if(optionalUsuario.isPresent()) {
			optionalUsuario.get().setEmail(usuario.getEmail());
			optionalUsuario.get().setNome(usuario.getNome());
			optionalUsuario.get().setTelefone(usuario.getTelefone());
			optionalUsuario.get().setQtdLivrosEmprestados(usuario.getQtdLivrosEmprestados());
			usuarioRepository.save(optionalUsuario.get());
		}
	}
	
	public void deleteUsuario(int id) {
		usuarioRepository.deleteById(id);
	}
	
	

}