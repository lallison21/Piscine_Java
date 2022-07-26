package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

	private Long id;
	private User sender;
	private Chatroom room;
	private String text;
	private Timestamp dateTime;

	public Message (Long id, User sender, Chatroom room, String text, Timestamp dateTime) {

		this.id = id;
		this.sender = sender;
		this.room =	room;
		this.text = text;
		this.dateTime = dateTime;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Message message = (Message) o;

		return Objects.equals(id, message.id) && Objects.equals(sender, message.sender)
				&& Objects.equals(room, message.room) && Objects.equals(text, message.text)
				&& Objects.equals(dateTime, message.dateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, sender, room, text, dateTime);
	}

	@Override
	public String toString() {

		return "Message : {\n" +
				"\tid=" + id +
				",\n\tauthor=" + sender +
				",\n\troom=" + room +
				",\n\ttext='" + text + '\'' +
				",\n\tdateTime=" + dateTime +
				"\n}";
	}
}
