package br.com.alura.challenge.bookstoreapi.service;


import java.util.Random;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.AutorFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import br.com.alura.challenge.bookstoreapi.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository ar;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public Page<AutorDto> listar(Pageable paginacao) {
		Page<Autor> autores = ar.findAll(paginacao);
		return autores
				.map(t -> modelMapper.map(t, AutorDto.class));
	}
	
	@Transactional
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
