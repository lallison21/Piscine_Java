package edu.shool21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

	private Long id;
	private String login;
	private String password;
	private List<Chatroom> rooms;
	private List<Chatroom> activeRooms;

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;

		return Objects.equals(id, user.id) && Objects.equals(login, user.login)
				&& Objects.equals(password, user.password) && Objects.equals(rooms, user.rooms)
				&& Objects.equals(activeRooms, user.activeRooms);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, login, password, rooms, activeRooms);
	}

	@Override
	public String toString() {

		return "User{" +
				"id=" + id +
				", login=" + login + '\'' +
				", password=" + password + '\'' +
				", rooms=" + rooms +
				", activeRooms=" + activeRooms +
				'}';
	}
}
