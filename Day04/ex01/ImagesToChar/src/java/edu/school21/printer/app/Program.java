package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.err.println("Error: Incorrect arguments");
			System.exit(-1);
		}

		char w = args[0].charAt(0);
		char b = args[1].charAt(0);

		int[][] array2d = Logic.seeBMPImage(b, w);

		for (int x = 0; x < array2d.length; x++) {

			for (int y = 0; y < array2d[x].length; y++) {
				System.out.print((char)array2d[y][x]);
			}

			System.out.println();

		}

	}

}
