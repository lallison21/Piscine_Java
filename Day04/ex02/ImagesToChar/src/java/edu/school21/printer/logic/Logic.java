package edu.school21.printer.logic;

import java.net.URL;
import java.awt.Color;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.api.Ansi;
import com.diogonunes.jcdp.color.ColoredPrinter;

@Parameters(separators = "=")

public class Logic {

    private URL image;
    @Parameter(names = {"--white", "-b"}, arity = 1)
    private String whitePixel;
    @Parameter(names = {"--black", "-w"}, arity = 1)
    
    private String blackPixel;

    public Logic(URL image) {
        this.image = image;
    }

    public void getImage() throws IOException {

        try {
            Ansi.BColor.valueOf(whitePixel);
            Ansi.BColor.valueOf(blackPixel);
        } catch (Exception e) {
            System.out.println("Error: Incorrect color argument");
            return ;
        }

        BufferedImage bufferedImage = ImageIO.read(image);
        
        ColoredPrinter coloredPrinter = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.NONE).background(Ansi.BColor.NONE)
                .build();

        int[][] arrayInt = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
        
        for (int x = 0; x < arrayInt.length; x++) {

            for (int y = 0; y < arrayInt[x].length; y++) {

                int color = bufferedImage.getRGB(y, x);

                if (color == Color.WHITE.getRGB()) {
                    coloredPrinter.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(whitePixel));
                } else {
                    coloredPrinter.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(blackPixel));
                }

            }

            System.out.println();

        }

    }

}
