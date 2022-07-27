package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

	private final DataSource dataSource;

	public ProductsRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> findAll() throws SQLException {
		List<Product> productList = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select * from testsTable;");

		while (resultSet.next()) {
			productList.add(new Product(
				resultSet.getLong(1),
				resultSet.getString(2),
				resultSet.getInt(3)));
		}

		statement.close();
		connection.close();

		return productList;
	}

	@Override
	public Optional<Product> findById(Long identifier) throws SQLException {

		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from testsTable where identifier=" + identifier + ";");
		if (!resultSet.next()) {
			throw new RuntimeException("Error: Object with specified id not found");
		}
		Product product = new Product(
				resultSet.getLong(1),
				resultSet.getString(2),
				resultSet.getInt(3));

		statement.close();
		connection.close();

		return Optional.of(product);
	}

	@Override
	public void update(Product product) throws SQLException {

		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update testsTable set name=?, price=? where identifier=?;");
		preparedStatement.setString(1, product.getName());
		preparedStatement.setInt(2, product.getPrice());
		preparedStatement.setLong(3, product.getIdentifier());

		preparedStatement.execute();

		preparedStatement.close();
		connection.close();
	}

	@Override
	public void save(Product product) throws SQLException {

		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into testsTable values (?, ?, ?);");
		preparedStatement.setLong(1, product.getIdentifier());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setInt(3, product.getPrice());
		preparedStatement.execute();

		preparedStatement.close();
		connection.close();
	}

	@Override
	public void delete(Long identifier) throws SQLException {

		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from testsTable where identifier=?;");
		preparedStatement.setLong(1, identifier);
		preparedStatement.execute();

		preparedStatement.close();
		connection.close();
	}
}
