package com.listacompra.listaCompra.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoSugeridoRepository extends JpaRepository<ProdutoSugerido, Integer> {
	
	ProdutoSugerido findById(int id);

}
