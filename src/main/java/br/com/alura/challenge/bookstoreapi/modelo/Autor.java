package br.com.alura.challenge.bookstoreapi.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"idade"})
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

	private String nome;
	private String matricula;
	private int idade;
	private String senha;
}
