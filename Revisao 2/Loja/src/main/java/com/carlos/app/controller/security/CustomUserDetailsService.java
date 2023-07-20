package com.carlos.app.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carlos.app.model.entity.Pessoa;
import com.carlos.app.model.repository.PessoaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Pessoa pessoa = pessoaRepository.findByEmail(email);
    	
    	if(pessoa != null) {
    		String username = pessoa.getEmail();
    		String password = pessoa.getSenha();
    		List<? extends GrantedAuthority> authorities = mapRolesToAuthorities(pessoa.getRole());
    		return new org.springframework.security.core.userdetails.User(username, password, authorities);
    	} else {
    		throw new UsernameNotFoundException("Usuario ou Senha Inválidos");
    	}
    }
    
    private List< ? extends GrantedAuthority> mapRolesToAuthorities(UserRole role) {
    	if(role == UserRole.ADMIN)
        	return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
        	return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
