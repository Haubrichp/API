package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.UsuarioResponseDTO;
import br.com.serratec.entity.Usuario;
import br.com.serratec.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> listar() {
		return service.listar();
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDTO inserir(@Valid @RequestBody UsuarioResponseDTO usuario) {
		return service.inserir(usuario);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Usuario> atualizar(Long id ,@RequestBody Usuario usuario) {
		if (service.equals(id)) {
	        service.atualizar(id, usuario);
	        return service.atualizar(id, usuario);
	    }
	    return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
