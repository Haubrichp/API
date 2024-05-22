package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Produto;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> listar() {
		
		return repository.findAll();
	}
	
	public Page<Produto> listarPorPagina(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	public Page<Produto> buscarPorFaixaSalarial(Double valorInicial, Double valorFinal, Pageable pageable) {
		
		Page<Produto> produtos = repository.findBySalarioBetween(valorInicial, valorFinal, pageable);
		return produtos;
	}
	
	public Page<Produto> buscarPorNome(String paramNome, Pageable pageable) {
		
		Page<Produto> produtos = repository.findByNomeContainingIgnoreCase(paramNome, pageable);
		return produtos;
	}
}
