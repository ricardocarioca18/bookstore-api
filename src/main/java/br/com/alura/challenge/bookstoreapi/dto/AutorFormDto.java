package br.com.alura.challenge.bookstoreapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String idade;
}
