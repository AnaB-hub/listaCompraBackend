package com.listacompra.listaCompra.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value = "API Lista de Produtos")
@CrossOrigin(origins = "*")
public class CompraController {
	
	@Autowired
	CompraRepository compraRepository;
	
	@GetMapping("/compras")
	public List<Compra> compras() {
		return compraRepository.findAll();
	}

}
