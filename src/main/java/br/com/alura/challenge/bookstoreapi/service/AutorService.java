package br.com.alura.challenge.bookstoreapi.service;


import java.util.Random;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.challenge.bookstoreapi.dto.AutorDto;
import br.com.alura.challenge.bookstoreapi.dto.form.AtualizacaoAutorFormDto;
import br.com.alura.challenge.bookstoreapi.dto.form.AutorFormDto;
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

	@Transactional
	public AutorDto atualizar(AtualizacaoAutorFormDto dto) {
		Autor autor = ar.getById(dto.getId());
		autor.atualizarIformacoes(dto.getNome(), dto.getIdade());
		return modelMapper.map(dto, AutorDto.class);
	}

	@Transactional
	public ResponseEntity<AutorDto> remover(Long id) {
		ar.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	public AutorDto detalhar(Long id) {
		Autor autor = ar
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return modelMapper.map(autor, AutorDto.class);
	}
}
