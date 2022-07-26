DROP TABLE IF EXISTS userTable CASCADE;
DROP TABLE IF EXISTS messageTable CASCADE;
CREATE TABLE userTable (identifier SERIAL PRIMARY KEY, name varchar(30) UNIQUE , password TEXT NOT NULL);
CREATE TABLE messageTable (id SERIAL PRIMARY KEY, text TEXT NOT NULL, time TIMESTAMP);