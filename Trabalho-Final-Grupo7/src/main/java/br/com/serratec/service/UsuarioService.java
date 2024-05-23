package br.com.serratec.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.UsuarioRequestDTO;
import br.com.serratec.dto.UsuarioResponseDTO;
import br.com.serratec.entity.Usuario;
import br.com.serratec.entity.Perfil;
import br.com.serratec.entity.Usuario;
import br.com.serratec.entity.UsuarioPerfil;
import br.com.serratec.entity.Usuario;
import br.com.serratec.exception.ConfirmaSenhaException;
import br.com.serratec.exception.EmailException;
import br.com.serratec.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listar() {

		return repository.findAll();
	}

	public Page<Usuario> listarPorPagina(Pageable pageable) {

		return repository.findAll(pageable);
	}

	public Usuario inserirUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario não pode ser nulo");
		}
		return repository.save(usuario);
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Usuario não encontrado");
		}
		repository.deleteById(id);
	}
	public Usuario atualizar(Long id, Usuario usuario)  {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario not found");
        }
        return repository.save(usuario);
	}
}
