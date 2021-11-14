package br.com.alura.challenge.bookstoreapi.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping
	public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable paginacao){
		return service.listar(paginacao);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid LivroFormDto dto) {
		service.cadastrar(dto);
	}
	
	

	
}
