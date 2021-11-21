package br.com.alura.challenge.bookstoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro400Dto {

	private String campo;
	private String mensagem;
}
