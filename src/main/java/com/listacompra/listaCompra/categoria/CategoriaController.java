package com.listacompra.listaCompra.categoria;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API Lista de Produtos")
@CrossOrigin(origins = "*")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	@ApiOperation(value="Lista de categorias")
	private List<Categoria> categorias() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/categoriasAtivas")
	@ApiOperation(value="Lista de categorias ativas")
	private Stream<Categoria> categoriasAtivas() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias.stream().filter(c -> c.isAtivo() == true);
	}
	
	@GetMapping("/categorias/{id}")
	@ApiOperation(value="Retorna categoria pelo ID")
	private Categoria categoria(@PathVariable(value="id") int id) {
		return categoriaRepository.findById(id);
	}
	
	@PostMapping("/categorias")
	@ApiOperation(value="Cadastro de categoria")
	private Categoria saveCategoria(@RequestBody Categoria categoria) {
		categoria.setAtivo(true);
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/categorias")
	@ApiOperation(value="Alteração de categoria")
	private Categoria updateCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@GetMapping("/categorias/delete/{id}")
	@ApiOperation(value="Exclusão lógica de categoria")
	private void logicalExclusionCategoria(@PathVariable(value="id") int id) {
		Categoria categoria = categoriaRepository.findById(id);
		categoria.setAtivo(false);
		categoriaRepository.save(categoria);
	}

}
