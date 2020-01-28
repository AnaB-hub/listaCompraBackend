package com.listacompra.listaCompra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.listacompra.listaCompra.usuario.UsuarioRepository;

@Repository
public class ImplementUserDetailService implements UserDetailsService{

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
	
		UserDetails usr = null;
		
		usr = usuarioRepository.findByUsuario(login);
		
		if(usr == null) {
			throw new UsernameNotFoundException("Usuario não cadastrado!");
		}
		
		return usr;
	}

}
