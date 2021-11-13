package br.com.alura.challenge.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.challenge.bookstoreapi.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
