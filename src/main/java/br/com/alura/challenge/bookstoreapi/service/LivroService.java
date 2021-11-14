package br.com.alura.challenge.bookstoreapi.service;



import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;
import br.com.alura.challenge.bookstoreapi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public Page<LivroDto> listar(Pageable paginacao) {
		Page<Livro> livros = lr.findAll(paginacao);
		return livros
				.map(l -> modelMapper.map(l, LivroDto.class));
	}

	@Transactional
	public void cadastrar(@Valid LivroFormDto dto) {
		Livro l = modelMapper.map(dto, Livro.class);
		l.setId(null);
		lr.save(l);
	}
}
