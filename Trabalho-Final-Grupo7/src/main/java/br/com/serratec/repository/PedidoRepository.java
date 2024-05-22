package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE SALARIO BETWEEN :valorInicial AND :valorFinal",
//	nativeQuery = true)
//	public Page<Pedido> faixaSalarial (Double valorInicial, Double valorFinal, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE NOME ILIKE %:paramNome%",
//	nativeQuery = true)
//  public Page<Pedido> buscarPorNome (String paramNome, Pageable pageable);
	
	public Page<Pedido> findBySalarioBetween(Double valorInicial, Double valorFinal, Pageable pageable);
	
	public Page<Pedido> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
}


