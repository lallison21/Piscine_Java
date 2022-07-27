package edu.school21.repositories;

import edu.school21.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductsRepository {

	public List<Product> findAll() throws SQLException;

	public Optional<Product> findById(Long identifier) throws SQLException;

	public void update(Product product) throws SQLException;

	public void save(Product product) throws SQLException;

	public void delete(Long identifier) throws SQLException;
}
