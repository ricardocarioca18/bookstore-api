package br.com.alura.challenge.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	@Query("select new br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto("
			+ "l.autor.nome, "
			+ "count(l.titulo), "
			+ "(select count(l2.titulo) from Livro l2)) "
			+ "from Livro l "
			+ "group by l.autor")
	List<ItemLivrosPorAutorDto> relatorioLivrosPorAutor();
}
