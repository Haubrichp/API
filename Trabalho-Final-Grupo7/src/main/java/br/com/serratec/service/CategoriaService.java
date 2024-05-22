package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Categoria;
import br.com.serratec.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> listar() {
		
		return repository.findAll();
	}
	
	public Page<Categoria> listarPorPagina(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	public Page<Categoria> buscarPorFaixaSalarial(Double valorInicial, Double valorFinal, Pageable pageable) {
		
		Page<Categoria> categorias = repository.findBySalarioBetween(valorInicial, valorFinal, pageable);
		return categorias;
	}
	
	public Page<Categoria> buscarPorNome(String paramNome, Pageable pageable) {
		
		Page<Categoria> categorias = repository.findByNomeContainingIgnoreCase(paramNome, pageable);
		return categorias;
	}
}
