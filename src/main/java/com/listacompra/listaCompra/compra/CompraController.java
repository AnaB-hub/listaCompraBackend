package com.listacompra.listaCompra.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/compras/{id}")
	public Compra compra(@PathVariable(value="id") int id) {
		return compraRepository.findById(id);
	}
	
	@PostMapping("/compras")
	public Compra saveCompra(@RequestBody Compra compra) {
		return compraRepository.save(compra);
	}
	
	@DeleteMapping("/compras/{id}")
	public void deleteCompra(@PathVariable(value="id") int id) {
		compraRepository.deleteById(id);
	}

}
