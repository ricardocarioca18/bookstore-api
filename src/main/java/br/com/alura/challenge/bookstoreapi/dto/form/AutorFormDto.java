package br.com.alura.challenge.bookstoreapi.dto.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {

	@NotBlank
	private String nome;
	@DecimalMin("18")
	private Integer idade;
}
