package com.listacompra.listaCompra.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findById(int id);

}
