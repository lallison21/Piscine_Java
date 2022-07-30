package edu.school21.clientsocket.client;

import java.io.*;
import java.net.Socket;

public class Client {

	private final String[] args;
	private int port;

	public Client(String[] args) {
		this.args = args;
	}

	public void start() {

		if (isArgsChecker()) {
			return ;
		}

		try (Socket socket = new Socket("localhost", port)) {

			try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
				 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

				System.out.println(in.readLine());

				String singUp = console.readLine();
				out.write(singUp + "\n");
				out.flush();

				String signUp = in.readLine();
				System.out.println(signUp);

				if (signUp.equals("Error: you should to put \"signUp\"")) {
					return ;
				}

				String login = console.readLine();

				out.write(login + "\n");
				out.flush();

				System.out.println(in.readLine());

				String password = console.readLine();

				out.write(password + "\n");
				out.flush();

				System.out.println(in.readLine());

			}
		} catch (IOException e) {
			System.err.println("Error: Server doesn't not exist!");
		}
	}

	private boolean isArgsChecker() {

		if (args.length != 1) {
			System.err.println("Error: Wrong count of arguments");
			return true;
		}

		if (!args[0].startsWith("--server-port=")) {
			System.out.println("Error: Wrong parameter of arguments");
			return true;
		}

		try {
			port = Integer.parseInt(args[0].replaceFirst("--server-port=", ""));
		} catch (NumberFormatException e) {
			System.err.println("Error: Wrong port arguments");
			return true;
		}

		return false;
	}
}
