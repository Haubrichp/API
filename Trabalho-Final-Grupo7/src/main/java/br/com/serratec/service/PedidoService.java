package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Pedido;
import br.com.serratec.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> listar() {
		
		return repository.findAll();
	}
	
	public Page<Pedido> listarPorPagina(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	
}
