package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static java.sql.Types.BIGINT;
import static java.sql.Types.VARCHAR;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

	private final JdbcTemplate jdbcTemplate;

	public UsersRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User findById(Long id) {
		return jdbcTemplate
				.query("select from singInTable where id=?",
						new Object[]{id},
						new int[]{BIGINT},
						new BeanPropertyRowMapper<>(User.class))
				.stream().findAny().orElse(null);
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate
				.query("select * from singInTable",
						new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public void save(User entity) {
		jdbcTemplate.update("insert into singInTable (login, password) values (?, ?)",
				entity.getLogin(),
				entity.getPassword());
	}

	@Override
	public void update(User entity) {
		jdbcTemplate.update("update singInTable set login=?, password=? where id=?",
				entity.getLogin(),
				entity.getPassword(),
				entity.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("delete from singInTable where id=?", id);
	}

	@Override
	public Optional<User> findByName(String name) {
		return jdbcTemplate
				.query("select from singInTable where login=?",
						new Object[]{name},
						new int[]{VARCHAR},
						new BeanPropertyRowMapper<>(User.class))
				.stream().findAny();
	}
}
