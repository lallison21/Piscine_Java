INSERT INTO chat.users (login, passwd) VALUES ('lallison', '123456789');
INSERT INTO chat.users (login, passwd) VALUES ('kferterb', '987654321');
INSERT INTO chat.users (login, passwd) VALUES ('gmalka', '147258369');
INSERT INTO chat.users (login, passwd) VALUES ('teusebio', '963852741');
INSERT INTO chat.users (login, passwd) VALUES ('pcorina', '321654987');

INSERT INTO char.room (chat_owner, chat_name) VALUES (1, 'chat1');
INSERT INTO char.room (chat_owner, chat_name) VALUES (2, 'chat2');
INSERT INTO char.room (chat_owner, chat_name) VALUES (3, 'chat3');
INSERT INTO char.room (chat_owner, chat_name) VALUES (4, 'chat4');
INSERT INTO char.room (chat_owner, chat_name) VALUES (5, 'chat5');

INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (1, 2, 'Hello Guys', current_timestamp);
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (1, 1, 'Hello, kferterb', current_timestamp);
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (5, 3, 'Alahagbar!!!', current_timestamp);
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (5, 4, 'OMG!!!', current_timestamp);
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (2, 5, 'HAHAHAHA!!!', current_timestamp);