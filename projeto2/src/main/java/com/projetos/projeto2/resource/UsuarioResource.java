package com.projetos.projeto2.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "api/projeto_2")
public class UsuarioResource {
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario buscaIdUsuario(@PathVariable(value = "id") long id) {
		return usuarioRepository.findById(id);
	}
	
	@PutMapping("/usuario")
	public Usuario alteraUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("/usuario")
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public String deleteUsuario (@PathVariable long id) {
		Usuario usuario = new Usuario();
		usuario = usuarioRepository.findById(id);
		usuarioRepository.deleteById(id);
		return "Usuario Excluido: " + usuario.getNome();
		
		
	}

}
