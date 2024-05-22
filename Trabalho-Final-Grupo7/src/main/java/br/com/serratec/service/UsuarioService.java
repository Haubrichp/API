package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Usuario;
import br.com.serratec.repository.UsuarioRepository;

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
	
	public Page<Usuario> buscarPorFaixaSalarial(Double valorInicial, Double valorFinal, Pageable pageable) {
		
		Page<Usuario> usuarios = repository.findBySalarioBetween(valorInicial, valorFinal, pageable);
		return usuarios;
	}
	
	public Page<Usuario> buscarPorNome(String paramNome, Pageable pageable) {
		
		Page<Usuario> usuarios = repository.findByNomeContainingIgnoreCase(paramNome, pageable);
		return usuarios;
	}
}
