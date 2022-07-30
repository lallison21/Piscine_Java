package edu.school21.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Server {

	private final String[] args;
	private int port;

	public Server(String[] args) {
		this.args = args;
	}

	public void start() {

		if (isArgsChecker()) {
			return ;
		}

		try	(ServerSocket serverSocket = new ServerSocket(port)) {

			Socket socket = serverSocket.accept();

			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

				out.write("Hello from Server!\n");
				out.flush();

				String input = in.readLine();
				if (!input.equals("signUp")) {
					out.write("Error: you should to put \"signUp\"\n");
					out.flush();
					return;
				}

				out.write("Enter login:\n");
				out.flush();

				String login = in.readLine();

				out.write("Enter password:\n");
				out.flush();

				String password = in.readLine();

				ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);

				UsersService usersService = context.getBean(UsersService.class);

				out.write(usersService.saveNewUser(login, password));
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isArgsChecker() {

		if (args.length != 1) {
			System.err.println("Error: Wrong count of arguments");
			return true;
		}

		if (!args[0].startsWith("--port=")) {
			System.out.println("Error: Wrong parameter of arguments");
			return true;
		}

		try {
			port = Integer.parseInt(args[0].replaceFirst("--port=", ""));
		} catch (NumberFormatException e) {
			System.err.println("Error: Wrong port arguments");
			return true;
		}

		return false;
	}
}
