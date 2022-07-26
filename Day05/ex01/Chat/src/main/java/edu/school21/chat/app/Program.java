package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {

		List<String> schemaQuery;
		List<String> dataQuery;

		try {
			schemaQuery = Files.readAllLines(Paths.get("../src/main/resources/schema.sql"));
			dataQuery = Files.readAllLines(Paths.get("../src/main/resources/data.sql"));
		} catch (IOException e) {
			e.printStackTrace();
			return ;
		}

		HikariDataSource hikariDataSource = new HikariDataSource();

		hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		hikariDataSource.setUsername("postgres");
		hikariDataSource.setPassword("");

		Connection connection = hikariDataSource.getConnection();

		createSchema(connection, schemaQuery);
		insertToDB(connection, dataQuery);

		MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);

		System.out.println("Enter a message ID");
		System.out.print("-> ");

		Optional<Message> message;

		try (Scanner scanner = new Scanner(System.in)) {
			message = messagesRepository.findById(scanner.nextLong());
		} catch (InputMismatchException e) {
			e.printStackTrace();
			return ;
		}

		if (message.isPresent()) {
			System.out.println(message.get());
		} else {
			System.out.println("null");
		}
	}

	private static void insertToDB(Connection connection, List<String> dataQueries) throws SQLException {

		for (String dataQuery : dataQueries) {
			connection.createStatement().execute(dataQuery);
		}
	}

	private static void createSchema(Connection connection, List<String> schemaQueries) throws SQLException {

		for (String schemaQuery : schemaQueries) {
			connection.createStatement().execute(schemaQuery);
		}
	}
}
