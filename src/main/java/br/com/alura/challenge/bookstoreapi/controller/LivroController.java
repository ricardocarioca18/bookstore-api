package br.com.alura.challenge.bookstoreapi.controller;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.challenge.bookstoreapi.dto.DetalheLivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.form.AtualizacaoLivroFormDto;
import br.com.alura.challenge.bookstoreapi.dto.form.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/livros")
@Api(tags = "Livro")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping
	@ApiOperation("Listar livros")
	public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable paginacao){
		return service.listar(paginacao);
	}
	
	@PostMapping
	@ApiOperation("Cadastrar livro")
	public void cadastrar(@RequestBody @Valid LivroFormDto dto) {
		service.cadastrar(dto);
	}
	
	@PutMapping
	public ResponseEntity<LivroDto> atualizar(@RequestBody @Valid AtualizacaoLivroFormDto dto){
		LivroDto atualizado = service.atualizar(dto);
		return ResponseEntity.ok(atualizado);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LivroDto> remover(@PathVariable @NotNull Long id){
		service.remover(id);
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDto> detalhar(@PathVariable @NotNull Long id){
		DetalheLivroDto dto = service.detalhar(id);
		return ResponseEntity.ok(dto);
	}
}
