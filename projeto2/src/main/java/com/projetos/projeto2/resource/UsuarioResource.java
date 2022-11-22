package com.projetos.projeto2.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.projeto2.models.Usuario;
import com.projetos.projeto2.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/projeto_2")
@Api(value = "API - REST USUARIO")
@CrossOrigin(origins = "*")
public class UsuarioResource {
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value = "Lista usuarios")
	public List<Usuario> listUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	@ApiOperation(value = "Busca Usuario")
	public Usuario buscaIdUsuario(@PathVariable(value = "id") long id) {
		return usuarioRepository.findById(id);
	}
	
	@PutMapping("/usuario")
	@ApiOperation(value = "Altera Usuario")
	public Usuario alteraUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("/usuario")
	@ApiOperation(value = "Cria Usuario")
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	@ApiOperation(value = "Deleta Usuario")
	public String deleteUsuario (@PathVariable long id) {
		Usuario usuario = new Usuario();
		usuario = usuarioRepository.findById(id);
		usuarioRepository.deleteById(id);
		return "Usuario Excluido: " + usuario.getNome();
		
		
	}

}
