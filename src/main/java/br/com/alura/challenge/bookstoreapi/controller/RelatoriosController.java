package br.com.alura.challenge.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto;
import br.com.alura.challenge.bookstoreapi.service.RelatoriosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/relatorios")
@Api(tags = "Relatórios")
public class RelatoriosController {

	@Autowired
	private RelatoriosService service;
	
	@GetMapping("/livrosPorAutor")
	@ApiOperation("Relatório de livros por autor")
	public List<ItemLivrosPorAutorDto> relatorioLivrosPorAutor(){
		return service.relatorioLivrosPorAutor();
	}
}
