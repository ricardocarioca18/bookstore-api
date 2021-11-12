package br.com.alura.challenge.bookstoreapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.AutorFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Autor;

@Service
public class AutorService {
	
	ModelMapper modelMapper = new ModelMapper();
	private List<Autor> autores = new ArrayList<>();
	
	
	public List<AutorDto> listar() {
		return autores
				.stream()
				.map(t -> modelMapper.map(t, AutorDto.class))
				.collect(Collectors.toList());
	}
	
	
	public void cadastrar(@Valid AutorFormDto dto) {
		Autor a = modelMapper.map(dto, Autor.class);
		
		String senha = new Random().nextInt(99999)+"";
		a.setSenha(senha);
		String matricula = new Random().nextInt(99999)+"";
		a.setMatricula(matricula);
		System.out.println("Matricula: "+a.getMatricula()+"\tSenha: "+a.getSenha());
		autores.add(a);
		
	}
}
