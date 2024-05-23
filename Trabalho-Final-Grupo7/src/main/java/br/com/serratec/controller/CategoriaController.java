package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Categoria;
import br.com.serratec.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
//	
//	@GetMapping("/pagina")
//	public Page<Categoria> listarPorPagina(@PageableDefault(sort = "nome", page = 1, size = 10) 
//	Pageable pageable) {
//		
//		return service.listarPorPagina(pageable);
	}
	
