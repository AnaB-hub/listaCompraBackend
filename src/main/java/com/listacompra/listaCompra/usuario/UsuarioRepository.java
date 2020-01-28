package com.listacompra.listaCompra.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findById(int id);
	
	@Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
	Usuario findByUsuario(@Param("usuario")String usuario);

}
