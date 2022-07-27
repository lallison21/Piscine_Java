package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
	ProductsRepository productsRepository;
	EmbeddedDatabase embeddedDatabase;

	final List<Product> EXECUTED_FIND_ALL_PRODUCT = Arrays.asList(
			new Product(0L, "t-shirt", 100),
			new Product(1L, "shirt", 75),
			new Product(2L, "dress", 125),
			new Product(3L, "suit", 300),
			new Product(4L, "skirt", 50),
			new Product(5L, "jeans", 100)
	);
	final Product EXECUTED_FIND_BY_IDENTIFIER_PRODUCT = new Product(1L, "shirt", 75);
	final Product EXECUTED_UPDATE_PRODUCT = new Product(3L, "dress", 100);
	final Product EXECUTED_SAVED_PRODUCT = new Product(7L, "table", 1000);

	@BeforeEach
	void init() throws SQLException {
		embeddedDatabase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("schema.sql")
				.addScript("data.sql")
				.build();
		productsRepository = new ProductsRepositoryJdbcImpl(embeddedDatabase);
	}

	@Test
	void testFindAll() throws SQLException {
		Assertions.assertEquals(EXECUTED_FIND_ALL_PRODUCT, productsRepository.findAll());
	}

	@Test
	void testFindById() throws SQLException {
		Assertions.assertEquals(productsRepository.findById(1L).get(), EXECUTED_FIND_BY_IDENTIFIER_PRODUCT);
	}

	@Test
	void testUpdate() throws SQLException {
		productsRepository.update(EXECUTED_UPDATE_PRODUCT);
		Assertions.assertEquals(productsRepository.findById(3L).get(), EXECUTED_UPDATE_PRODUCT);
	}

	@Test
	void testSave() throws SQLException {
		productsRepository.save(EXECUTED_SAVED_PRODUCT);
		Assertions.assertEquals(productsRepository.findById(7L).get(), EXECUTED_SAVED_PRODUCT);
	}

	@Test
	void testDelete() throws SQLException {
		productsRepository.delete(1L);
		Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
	}

	@AfterEach
	void close() {
		embeddedDatabase.shutdown();
	}
}
