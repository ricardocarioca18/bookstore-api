package br.com.alura.challenge.bookstoreapi.dto.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoLivroFormDto extends LivroFormDto{

	@NotNull
	private Long id;
}
