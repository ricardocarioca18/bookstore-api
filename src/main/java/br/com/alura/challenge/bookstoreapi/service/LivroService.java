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
import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;
import br.com.alura.challenge.bookstoreapi.repository.AutorRepository;
import br.com.alura.challenge.bookstoreapi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	@Autowired
	private AutorRepository ar;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public Page<LivroDto> listar(Pageable paginacao) {
		Page<Livro> livros = lr.findAll(paginacao);
		return livros
				.map(l -> modelMapper.map(l, LivroDto.class));
	}

	@Transactional
	public LivroDto cadastrar(@Valid LivroFormDto dto) {
		Long idAutor = dto.getAutorId();
		
		try {
			Autor autor = ar.getById(idAutor);
			Livro l = modelMapper.map(dto, Livro.class);
			l.setId(null);
			l.setAutor(autor);
			//lr.save(l);
			return modelMapper.map(l, LivroDto.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("Autor inexistente!");
		}
		
	}
}
