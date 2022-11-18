package com.projetos.projeto2.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.projeto2.models.Usuario;
import com.projetos.projeto2.repository.UsuarioResoitory;

@RestController
@RequestMapping(value = "api/projeto_2")
public class UsuarioResource {
	
	@Autowired UsuarioResoitory usuarioResoitory;
	
	@GetMapping("produtos")
	public List<Usuario> listUsuario(){
		return usuarioResoitory.findAll();
	}

}
