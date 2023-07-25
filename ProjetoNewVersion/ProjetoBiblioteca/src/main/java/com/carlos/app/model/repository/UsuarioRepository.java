package com.carlos.app.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carlos.app.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	 @Query(
		        value = "SELECT * FROM usuario u WHERE u.email = ?1",
		        nativeQuery = true
		    )
	Optional<Usuario> findByLogin(String login);
}
