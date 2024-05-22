package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE SALARIO BETWEEN :valorInicial AND :valorFinal",
//	nativeQuery = true)
//	public Page<Produto> faixaSalarial (Double valorInicial, Double valorFinal, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE NOME ILIKE %:paramNome%",
//	nativeQuery = true)
//	public Page<Produto> buscarPorNome (String paramNome, Pageable pageable);
	
	public Page<Produto> findBySalarioBetween(Double valorInicial, Double valorFinal, Pageable pageable);
	
	public Page<Produto> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
}


