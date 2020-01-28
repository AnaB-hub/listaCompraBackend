package com.listacompra.listaCompra.produto;

import java.util.Collections;
import java.util.Comparator;
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

import com.listacompra.listaCompra.categoria.CategoriaSugerida;
import com.listacompra.listaCompra.categoria.CategoriaSugeridaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Lista de Produtos")
@CrossOrigin(origins = "*")
public class ProdutoSugeridoController {
	
	@Autowired
	ProdutoSugeridoRepository produtoSugeridoRepository;
	
	@GetMapping("/produtos-sugeridos")
	@ApiOperation(value="Lista de produtos sugeridos")
	private List<ProdutoSugerido> produtos() {
		List<ProdutoSugerido> produtos = produtoSugeridoRepository.findAll();
		Collections.sort(produtos, Comparator.comparing(ProdutoSugerido::getNome));
		return produtos;
	}
	
	@PostMapping("/produtos-sugeridos")
	@ApiOperation(value="Cadastro produtos sugeridos")
	private ProdutoSugerido saveProdutoSugerido(
			@RequestBody ProdutoSugerido produtoSugerido) {
		return produtoSugeridoRepository.save(produtoSugerido);
	}
	
	@DeleteMapping("/produtos-sugeridos/{id}")
	@ApiOperation(value="Exclusão de produto sugerido")
	private void deleteProdutoSugerido(@PathVariable(value="id") int id) {
		produtoSugeridoRepository.deleteById(id);
	}

}
