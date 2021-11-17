package br.com.alura.challenge.bookstoreapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemLivrosPorAutorDto {

	private String autor;
	private Long quantidadeLivros;
	private Double percentual;
}
