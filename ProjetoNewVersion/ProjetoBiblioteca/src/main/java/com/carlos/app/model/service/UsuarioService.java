package com.carlos.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Usuario;
import com.carlos.app.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(int id) throws NotFoundException {
		return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	

	public Usuario updateUsuario(Usuario usuario, int id) throws NotFoundException {
		Usuario atualizado = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException());
		
		atualizado.setNome(usuario.getNome());
		atualizado.setTelefone(usuario.getTelefone());
		atualizado.setSenha(usuario.getSenha());
		atualizado.setEmail(usuario.getEmail());
		atualizado.setQuantidadeEmprestimo(usuario.getQuantidadeEmprestimo());
		
		usuarioRepository.save(atualizado);
		return atualizado;
	}
	
	public Usuario deleteUsuario(int id) throws NotFoundException {
		Usuario deletado = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException());
		usuarioRepository.delete(deletado);
		return deletado;
	}
}
