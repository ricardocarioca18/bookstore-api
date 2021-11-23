package br.com.alura.challenge.bookstoreapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.challenge.bookstoreapi.dto.LivroDto;
import br.com.alura.challenge.bookstoreapi.dto.LivroFormDto;
import br.com.alura.challenge.bookstoreapi.repository.AutorRepository;
import br.com.alura.challenge.bookstoreapi.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
	
	@Mock
	private LivroRepository lr;
	
	@Mock
	private AutorRepository ar;
	
	@InjectMocks
	private LivroService ls;
	
	@Test
	void deveriaCadastrarUmLivro() {
		LivroFormDto formDto = new LivroFormDto(
				"Percy Jackson e o Ladrão de Raios",
				LocalDate.now(),
				250,
				15l
				);
		
		LivroDto dto = ls.cadastrar(formDto);
		
		//Mockito.verify(lr.save(Mockito.any()));
		
		assertEquals(dto.getTitulo(), formDto.getTitulo());
		assertEquals(dto.getNumeroDePaginas(), formDto.getNumeroDePaginas());
		assertEquals(dto.getDataDeLancamento(), formDto.getDataDeLancamento());
	}

	@Test
	void naoDeveriaCadastrarUmLivroComAutorQueNaoExiste() {
		LivroFormDto formDto = new LivroFormDto(
				"Percy Jackson e o Ladrão de Raios",
				LocalDate.now(),
				250,
				15l
				);
		Mockito
		.when(ar.getById(formDto.getAutorId()))
		.thenThrow(EntityNotFoundException.class);
		
		assertThrows(IllegalArgumentException.class, () -> ls.cadastrar(formDto));
	}

}
