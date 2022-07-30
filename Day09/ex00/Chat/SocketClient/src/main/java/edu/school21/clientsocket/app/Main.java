package edu.school21.clientsocket.app;

import edu.school21.clientsocket.client.Client;

public class Main {

	public static void main(String[] args) {

		Client client = new Client(args);
		client.start();
	}
}
