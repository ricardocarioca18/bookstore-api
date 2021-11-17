package br.com.alura.challenge.bookstoreapi.dto;


import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemLivrosPorAutorDto {

	private String autor;
	private Long quantidadeLivros;
	private Double percentual;
}
