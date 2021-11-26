package br.com.alura.challenge.bookstoreapi.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.challenge.bookstoreapi.dto.ItemLivrosPorAutorDto;
import br.com.alura.challenge.bookstoreapi.modelo.Autor;
import br.com.alura.challenge.bookstoreapi.modelo.Livro;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

	@Autowired
	private LivroRepository lr;
	
	@Autowired
	private EntityManager em;
	
	@Test
	void deveriaRetornarRelatorioDeLivrosPorAutor() {
		Autor a1 = new Autor("Ricardo", "1237", 31, "123456");
		em.persist(a1);
		Autor a2 = new Autor("Marina", "0584", 29, "123456");
		em.persist(a2);
		Livro l1 = new Livro("O Código Da Vinci", LocalDate.of(1995, 2, 24), 600, a1);
		em.persist(l1);
		Livro l2 = new Livro("Origem da Vida", LocalDate.of(2000, 5, 10), 260, a1);
		em.persist(l2);
		Livro l3 = new Livro("Harry Potter e a Pedra Filosofal", LocalDate.of(1990, 1, 22), 300, a2);
		em.persist(l3);
		Livro l4 = new Livro("Harry Potter e a Câmara Secreta", LocalDate.of(1996, 4, 13), 420, a1);
		em.persist(l4);
		Livro l5 = new Livro("Mulheres que correm com lobos", LocalDate.of(2002, 7, 12), 800, a2);
		em.persist(l5);
		
		List<ItemLivrosPorAutorDto> relatorio = lr.relatorioLivrosPorAutor();
		//assertNotNull(relatorio);
		//assertEquals(2, relatorio.size());
		
		Assertions
		.assertThat(relatorio)
		.hasSize(2)
		.extracting(ItemLivrosPorAutorDto::getAutor, ItemLivrosPorAutorDto::getQuantidadeLivros, ItemLivrosPorAutorDto::getPercentual)
		.containsExactlyInAnyOrder(
					Assertions.tuple("Ricardo", 3l, 0.6),
					Assertions.tuple("Marina", 2l, 0.4)
				);
		
		
		
		
	}

}
