package edu.school21.chat.repositories;

import java.sql.*;
import java.util.Optional;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

	private final DataSource dataSource;

	public MessagesRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Optional<Message> findById(Long id) throws SQLException {

		Optional<Message> optionalMessage;

		Connection connection = dataSource.getConnection();

		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM chat.msgs WHERE id=" + id);
		resultSet.next();

		Long messageId = resultSet.getLong("id");
		long senderId = resultSet.getLong("sender");
		long roomId = resultSet.getLong("room_id");
		String message = resultSet.getString("message");
		Timestamp timestamp = resultSet.getTimestamp("time");

		ResultSet senderSet =  connection.createStatement().executeQuery("SELECT * FROM chat.users WHERE id=" + senderId);
		ResultSet roomSet = connection.createStatement().executeQuery("SELECT * FROM chat.room WHERE id=" + roomId);

		senderSet.next();
		roomSet.next();

		Long senderIdSet = senderSet.getLong("id");
		String senderLoginSet = senderSet.getString("login");
		String senderPasswdSet = senderSet.getString("passwd");

		Long roomIdSet = roomSet.getLong("id");
		String roomNameSet = roomSet.getString("chat_name");

		optionalMessage = Optional.of(new Message(messageId,
				new User(senderIdSet, senderLoginSet, senderPasswdSet, null, null),
				new Chatroom(roomIdSet, roomNameSet, null, null), message, timestamp));

		return optionalMessage;
	}
}
