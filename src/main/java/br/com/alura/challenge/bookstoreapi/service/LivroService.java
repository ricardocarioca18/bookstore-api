package br.com.alura.challenge.bookstoreapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;

@Service
public class LivroService {

	ModelMapper modelMapper = new ModelMapper();
	private List<Livro> livros = new ArrayList<>();
	
	
	public List<LivroDto> listar() {
		return livros
				.stream()
				.map(l -> modelMapper.map(l, LivroDto.class))
				.collect(Collectors.toList());
	}


	public void cadastrar(@Valid LivroFormDto dto) {
		Livro l = modelMapper.map(dto, Livro.class);
		livros.add(l);
	}
}
