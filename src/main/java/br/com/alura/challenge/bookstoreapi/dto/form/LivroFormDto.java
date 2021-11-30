package br.com.alura.challenge.bookstoreapi.dto.form;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroFormDto {

	@NotBlank @Size(min = 10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataDeLancamento;
	
	@DecimalMin("100")
	private int numeroDePaginas;
	
	@JsonAlias("autor_id")
	private Long autorId;
}
