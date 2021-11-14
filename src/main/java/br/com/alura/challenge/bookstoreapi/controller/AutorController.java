package br.com.alura.challenge.bookstoreapi.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.service.AutorService;
import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.AutorFormDto;

@RestController
@RequestMapping("/autores")
public class AutorController {
		
	@Autowired
	private AutorService service;
	
	@GetMapping
	public Page<AutorDto> listar(Pageable paginacao){
		return service.listar(paginacao);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
		service.cadastrar(dto);
	}
}
