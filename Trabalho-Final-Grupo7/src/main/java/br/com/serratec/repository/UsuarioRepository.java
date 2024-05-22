package br.com.serratec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE SALARIO BETWEEN :valorInicial AND :valorFinal",
//			nativeQuery = true)
//	public Page<Usuario> faixaSalarial (Double valorInicial, Double valorFinal, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM FUNCIONARIO WHERE NOME ILIKE %:paramNome%",
//	nativeQuery = true)
//  public Page<Usuario> buscarPorNome (String paramNome, Pageable pageable);
	
	public Page<Usuario> findBySalarioBetween(Double valorInicial, Double valorFinal, Pageable pageable);
	
	public Page<Usuario> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
}


