package br.com.alura.challenge.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto;
import br.com.alura.challenge.bookstoreapi.service.RelatoriosService;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

	@Autowired
	private RelatoriosService service;
	
	@GetMapping("/livrosPorAutor")
	public List<ItemLivrosPorAutorDto> relatorioLivrosPorAutor(){
		return service.relatorioLivrosPorAutor();
	}
}
