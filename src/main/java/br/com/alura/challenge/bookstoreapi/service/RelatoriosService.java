package br.com.alura.challenge.bookstoreapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto;
import br.com.alura.challenge.bookstoreapi.repository.LivroRepository;

@Service
public class RelatoriosService {

	@Autowired
	private LivroRepository repository;
	
	public List<ItemLivrosPorAutorDto> relatorioLivrosPorAutor(){
		return repository.relatorioLivrosPorAutor();
	}
}
