package br.com.alura.challenge.bookstoreapi.service;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.AutorFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import br.com.alura.challenge.bookstoreapi.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository ar;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public List<AutorDto> listar() {
		List<Autor> autores = ar.findAll();
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
		
		ar.save(a);
		
	}
}
