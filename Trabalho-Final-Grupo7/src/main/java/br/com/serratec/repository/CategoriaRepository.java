package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE SALARIO BETWEEN :valorInicial AND :valorFinal",
//	nativeQuery = true)
//	public Page<Categoria> faixaSalarial (Double valorInicial, Double valorFinal, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE NOME ILIKE %:paramNome%",
//	nativeQuery = true)
//  public Page<Categoria> buscarPorNome (String paramNome, Pageable pageable);
	
	public Page<Categoria> findBySalarioBetween(Double valorInicial, Double valorFinal, Pageable pageable);
	
	public Page<Categoria> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
}


