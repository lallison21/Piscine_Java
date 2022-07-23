package edu.school21.printer.app;

import java.net.URL;
import java.io.IOException;
import edu.school21.printer.logic.Logic;
import com.beust.jcommander.JCommander;

public class Program {

    public static void main(String[] args) {

        URL path = Program.class.getResource("/resources/image.bmp");

        Logic image;
        
        try {
            image = new Logic(path);
            JCommander.newBuilder().addObject(image).build().parse(args);
        } catch (Exception e) {
            System.out.println("Error: Incorrect arguments");
            return;
        }

        try {
            image.getImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
