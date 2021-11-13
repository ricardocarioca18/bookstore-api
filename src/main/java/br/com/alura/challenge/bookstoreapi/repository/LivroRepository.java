package br.com.alura.challenge.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.challenge.bookstoreapi.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
