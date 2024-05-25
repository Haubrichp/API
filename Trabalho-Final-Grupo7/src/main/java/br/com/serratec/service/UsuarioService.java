package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.configuration.MailConfig;
import br.com.serratec.dto.UsuarioResponseDTO;
import br.com.serratec.entity.Usuario;
import br.com.serratec.exception.EmailException;
import br.com.serratec.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private MailConfig mailConfig;

	public List<Usuario> listar() {

		return repository.findAll();
	}

	@Transactional
	public UsuarioResponseDTO inserir(UsuarioResponseDTO usuario) {
		
		if (repository.findByEmail(usuario.getEmail()) != null) {
			throw new EmailException("Email Já Existe na Base");
		}
		Usuario u = new Usuario();
		u.setNome(usuario.getNome());
		u.setTelefone(usuario.getTelefone());
		u.setEmail(usuario.getEmail());
		u.setCpf(usuario.getCpf());
		u.setSenha(usuario.getSenha());
	
		
		repository.save(u);
        mailConfig.sendMail(u.getEmail(),"Cadastro de Usuário no Sistema" ,u.toString());
		return new UsuarioResponseDTO(u);

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
