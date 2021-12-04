package br.com.alura.challenge.bookstoreapi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String matricula;
	private Integer idade;
	private String senha;
	
	public Autor(String nome, String matricula, Integer idade, String senha) {
		this.nome = nome;
		this.matricula = matricula;
		this.idade = idade;
		this.senha = senha;
	}

	public void atualizarIformacoes(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	
}
