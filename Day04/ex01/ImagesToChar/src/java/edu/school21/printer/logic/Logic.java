package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {

	public static int[][] seeBMPImage(char b, char w) throws IOException {

		BufferedImage bufferedImage = ImageIO.read(Logic.class.getResource("/resources/it.bmp"));

		int[][] array2d = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];

		for (int x = 0; x < bufferedImage.getWidth(); x++) {

			for (int y = 0; y < bufferedImage.getHeight(); y++) {

				int color = bufferedImage.getRGB(x, y);

				if (color == Color.BLACK.getRGB()) {
					array2d[x][y] = b;
				} else if (color == Color.WHITE.getRGB()) {
					array2d[x][y] = w;
				}

			}

		}

		return array2d;

	}

}
