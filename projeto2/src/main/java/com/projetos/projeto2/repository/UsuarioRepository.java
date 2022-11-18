package com.projetos.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.projeto2.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findById (long id);
	
}
