package br.com.alura.challenge.bookstoreapi.dto.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoAutorFormDto extends AutorFormDto{

	@NotNull
	private Long id;
}
