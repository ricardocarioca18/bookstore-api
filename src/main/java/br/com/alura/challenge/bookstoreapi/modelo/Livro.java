package br.com.alura.challenge.bookstoreapi.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

	private String titulo;
	private LocalDate dataDeLancamento;
	private int numeroDePaginas;
	private Autor autor;
}
