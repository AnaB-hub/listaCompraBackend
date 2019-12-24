package com.listacompra.listaCompra.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	Categoria findById(int id);

}
