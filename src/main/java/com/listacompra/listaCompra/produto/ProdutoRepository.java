package com.listacompra.listaCompra.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Produto findById(int id);
	
	@Query("SELECT p FROM Produto p WHERE p.nome = :nome AND p.ativo = true")
	Produto findAtivoByNome(@Param("nome")String nome);

}
