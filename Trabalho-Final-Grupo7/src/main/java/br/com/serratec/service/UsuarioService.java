package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.entity.Usuario;
import br.com.serratec.entity.Usuario;
import br.com.serratec.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listar() {

		return repository.findAll();
	}

	public Usuario inserir(@Valid @RequestBody Usuario usuario) {
		return repository.save(usuario);

	}

	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		if (repository.existsById(id)) {
			usuario.setId(id);
			return ResponseEntity.ok(repository.save(usuario));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<String> deletar(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.ok("Usuario com id " + id + " foi excluído com sucesso.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com id " + id + " não encontrado.");
	}

}
