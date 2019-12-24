package com.listacompra.listaCompra.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaSugeridaRepository extends JpaRepository<CategoriaSugerida, Integer> {
	
	CategoriaSugerida findById(int id);

}
