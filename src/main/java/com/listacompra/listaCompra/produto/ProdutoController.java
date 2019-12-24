package com.listacompra.listaCompra.produto;

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
@RequestMapping(value = "/api")
@Api(value = "API Lista de Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Lista de produtos")
	public List<Produto> produtos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtosAtivos")
	@ApiOperation(value="Lista de produtos ATIVOS")
	public Stream<Produto> produtosAtivos() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().filter(p -> p.isAtivo() == true);
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna produto pelo ID")
	public Produto produto(@PathVariable(value="id") int id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Cadastro de produto")
	public Produto saveProduto(@RequestBody Produto produto) {
		produto.setAtivo(true);
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="Alteração de produto")
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@GetMapping("/produtos/delete/{id}")
	@ApiOperation(value="Exclusão lógica de produto")
	public void logicalExclusionProduto(@PathVariable(value="id") int id) {
		Produto produto = produtoRepository.findById(id);
		produto.setAtivo(false);
		produtoRepository.save(produto);
	}

}
