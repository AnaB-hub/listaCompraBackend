package com.listacompra.listaCompra.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value="Lista de usuários")
	public List<Usuario> usuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="Retorna usuário pelo ID")
	Usuario usuario(@PathVariable(value="id")int id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario")
	@ApiOperation(value="Cadastro de usuário")
	Usuario saveUsuario(@RequestBody Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario")
	@ApiOperation(value="Alteração de usuário")
	Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	@ApiOperation(value="Exclusão de usuário")
	private void deleteUsuario(@PathVariable(value="id") int id) {
		usuarioRepository.deleteById(id);
	}
	
	@GetMapping("/usuario/findByUser/{user}")
	@ApiOperation(value="Retorna usuário pelo nome de usuário")
	Usuario usuarioByUser(@PathVariable(value="user")String user) {
		return usuarioRepository.findByUsuario(user);
	}
	
}
