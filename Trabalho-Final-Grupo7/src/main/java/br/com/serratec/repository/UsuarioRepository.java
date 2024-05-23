package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}


