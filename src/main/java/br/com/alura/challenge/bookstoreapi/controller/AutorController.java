package br.com.alura.challenge.bookstoreapi.controller;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.form.AtualizacaoAutorFormDto;
import br.com.alura.challenge.bookstoreapi.dto.form.AutorFormDto;

@RestController
@RequestMapping("/autores")
@Api(tags = "Autor")
public class AutorController {
		
	@Autowired
	private AutorService service;
	
	@GetMapping
	@ApiOperation("Listar autores")
	public Page<AutorDto> listar(Pageable paginacao){
		return service.listar(paginacao);
	}
	
	@PostMapping
	@ApiOperation("Cadastrar autor")
	public void cadastrar(@RequestBody @Valid AutorFormDto dto) {		
		service.cadastrar(dto);
	}
	
	@PutMapping
	@ApiOperation("Atualizar autor")
	public ResponseEntity<AutorDto> atualizar(@RequestBody @Valid AtualizacaoAutorFormDto dto) {		
		AutorDto atualizado = service.atualizar(dto);
		return ResponseEntity.ok(atualizado);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Deletar autor")
	public ResponseEntity<AutorDto> remover(@PathVariable Long id) {		
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Detalhar autor")
	public ResponseEntity<AutorDto> detalhar(@PathVariable @NotNull Long id) {		
		AutorDto autor = service.detalhar(id);
		return ResponseEntity.ok(autor);
	}
}
