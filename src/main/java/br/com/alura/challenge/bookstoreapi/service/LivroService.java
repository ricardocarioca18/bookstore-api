package br.com.alura.challenge.bookstoreapi.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;
import br.com.alura.challenge.bookstoreapi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public List<LivroDto> listar() {
		List<Livro> livros = lr.findAll();
		return livros
				.stream()
				.map(l -> modelMapper.map(l, LivroDto.class))
				.collect(Collectors.toList());
	}


	public void cadastrar(@Valid LivroFormDto dto) {
		Livro l = modelMapper.map(dto, Livro.class);
		lr.save(l);
	}
}
