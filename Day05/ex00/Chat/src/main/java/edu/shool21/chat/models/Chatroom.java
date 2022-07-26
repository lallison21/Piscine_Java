package edu.shool21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {

	private Long id;
	private String name;
	private String owner;
	private List<Message> messageList;

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Chatroom chatroom = (Chatroom) o;

		return Objects.equals(id, chatroom.id) && Objects.equals(name, chatroom.name)
				&& Objects.equals(owner, chatroom.owner) && Objects.equals(messageList, chatroom.messageList);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, owner, messageList);
	}

	@Override
	public String toString() {

		return "Chatroom{" +
				"id=" + id +
				", name='" + name + '\'' +
				", owner='" + owner + '\'' +
				", messageList=" + messageList +
				'}';
	}
}
