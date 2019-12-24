package com.listacompra.listaCompra.categoria;

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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Lista de Produtos")
@CrossOrigin(origins = "*")
public class CategoriaSugeridaController {
	
	@Autowired
	CategoriaSugeridaRepository categoriaSugeridaRepository;
	
	@GetMapping("/categorias-sugeridas")
	@ApiOperation(value="Lista de categorias sugeridas")
	private List<CategoriaSugerida> categorias() {
		return categoriaSugeridaRepository.findAll();
	}
	
	@PostMapping("/categorias-sugeridas")
	private CategoriaSugerida saveCategoriaSugerida(
			@RequestBody CategoriaSugerida categoriaSugerida) {
		return categoriaSugeridaRepository.save(categoriaSugerida);
	}
	
	@DeleteMapping("/categorias-sugeridas/{id}")
	private void deleteCategoriaSugerida(@PathVariable(value="id") int id) {
		categoriaSugeridaRepository.deleteById(id);
	}

}
