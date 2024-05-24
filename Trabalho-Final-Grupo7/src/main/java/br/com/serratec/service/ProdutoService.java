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

import br.com.serratec.entity.Produto;
import br.com.serratec.entity.Produto;
import br.com.serratec.repository.ProdutoRepository;
import br.com.serratec.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	
	public List<Produto> listar() {

		return repository.findAll();
	}

	public Produto inserir(@Valid @RequestBody Produto produto) {
		return repository.save(produto);

	}

	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		if (repository.existsById(id)) {
			produto.setId(id);
			return ResponseEntity.ok(repository.save(produto));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<String> deletar(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.ok("Produto com id " + id + " foi excluído com sucesso.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com id " + id + " não encontrado.");
	}

}
