package br.com.alura.challenge.bookstoreapi.dto;

import java.time.LocalDate;

//import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

	private String titulo;
	private LocalDate dataDeLancamento;
	private int numeroDePaginas;
	//private Autor autor;
}
