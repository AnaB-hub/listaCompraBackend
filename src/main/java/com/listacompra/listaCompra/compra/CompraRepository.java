package com.listacompra.listaCompra.compra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer>{
	
	Compra findById(int id);

}
