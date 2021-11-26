package br.com.alura.challenge.bookstoreapi.infra;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.challenge.bookstoreapi.dto.Erro400Dto;
import br.com.alura.challenge.bookstoreapi.dto.Erro404Dto;
import br.com.alura.challenge.bookstoreapi.dto.Erro500Dto;

@RestControllerAdvice
public class TratamentoDeErros {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<Erro400Dto> tratarErro400(MethodArgumentNotValidException ex){
		return ex
				.getFieldErrors()
				.stream()
				.map(erro -> new Erro400Dto(erro.getField(), erro.getDefaultMessage()))
				.collect(Collectors.toList());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Erro500Dto tratarErro500(Exception e, HttpServletRequest req) {
		return new Erro500Dto(
				LocalDate.now(), 
				e.getClass().toString(), 
				e.getMessage(), 
				req.getRequestURI());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Erro404Dto tratarErro404(Exception e, HttpServletRequest req) {
		return new Erro404Dto(
				LocalDate.now(), 
				e.getClass().toString(), 
				e.getMessage(), 
				req.getRequestURI());
	}
}
