package app;

import com.zaxxer.hikari.HikariDataSource;
import models.User;

import java.sql.SQLException;

public class Program {

	public static final String DB_URL = "jdbc:postgresql://localhost/";
	public static final String DB_USER = "postgres";

	public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		try (HikariDataSource dataSource = new HikariDataSource()) {
			dataSource.setJdbcUrl(DB_URL);
			dataSource.setUsername(DB_USER);
			dataSource.setPassword(null);

			OrmManager ormManager = new OrmManager(dataSource);
			User user = new User("Lenn", "Alison", 100);
			ormManager.save(user);
			user.setId(1L);
			user.setFirstName("Kamil");
			user.setLastName("Kamalov");
			user.setAge(35);
			ormManager.update(user);
			User user1 = ormManager.findById(1L, User.class);
			System.out.println(user1);
		}
	}
}
