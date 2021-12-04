package br.com.alura.challenge.bookstoreapi.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@Column(name="datadelancamento")
	private LocalDate dataDeLancamento;
	
	@Column(name="numerodepaginas")
	private Integer numeroDePaginas;
	
	@ManyToOne
	private Autor autor;

	public Livro(String titulo, LocalDate dataDeLancamento, Integer numeroDePaginas, Autor autor) {
		this.titulo = titulo;
		this.dataDeLancamento = dataDeLancamento;
		this.numeroDePaginas = numeroDePaginas;
		this.autor = autor;
	}

	public void atualizarInformacoes(String titulo, LocalDate dataDeLancamento, Integer numeroDePaginas) {
		this.titulo = titulo;
		this.dataDeLancamento = dataDeLancamento;
		this.numeroDePaginas = numeroDePaginas;
	}
	
	
}
