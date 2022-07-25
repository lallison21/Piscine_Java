package game;

import java.util.Scanner;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import chaselogic.ChaseLogic;
import chaselogic.Map;

public class RunGame {
    
    private final char[][] matrix;
    private final Map map;
    private final Integer size;
    private final String profile;

    public RunGame(char[][] matrix, Map map, Integer size, String profile) {

        this.matrix = matrix;
        this.map = map;
        this.size = size;
        this.profile = profile;

    }

    public void run() {

        ColoredPrinter coloredPrinter = new ColoredPrinter
                .Builder(1, false)
                .foreground(Ansi.FColor.BLACK)
                .build();

        printMatrix(coloredPrinter);

        Scanner scanner = new Scanner(System.in);
        Move move = new Move(matrix, size, map);
        ChaseLogic chaseLogic = new ChaseLogic(matrix, size, map);

        while (true) {

            System.out.println("Your move, press h for help");
            String s = scanner.nextLine();

            if (s.equals("q")) {
                break;
            }
        
            switch (s) {
                case "w":
                    move.up();
                    break;
                case "s":
                    move.down();
                    break;
                case "a":
                    move.left();
                    break;
                case "d":
                    move.right();
                    break;
                case "h":
                    System.out.println("w - up; s - down, a - left, d - right, q - exit");
                    continue;
                default:
                    System.out.println("w - UP, s - DOWN, a - LEFT, d - RIGHT");
                    continue;
            }

            if (profile.equals("production")) {
                chaseLogic.move();
                System.out.println();
            }

            printMatrix(coloredPrinter);

            if (profile.equals("dev")) {

                System.out.println("Accept enemy move by entering 8 or decline by entering 7");
                String input = scanner.nextLine();
                while (!"8".equals(input) && !"7".equals(input)) {
                    System.out.println("Accept enemy move by entering 8 or decline by entering 7");
                    input = scanner.nextLine();
                }
                if ("8".equals(input)) {
                    chaseLogic.move();
                }
                printMatrix(coloredPrinter);

            }

        }

        scanner.close();
    }

    private void printMatrix(ColoredPrinter coloredPrinter) {

        try {
            Ansi.BColor.valueOf(map.getEmptyColor());
            Ansi.BColor.valueOf(map.getPlayerColor());
            Ansi.BColor.valueOf(map.getGoalColor());
            Ansi.BColor.valueOf(map.getWallColor());
            Ansi.BColor.valueOf(map.getEnemyColor());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: bad color in property");
            System.exit(-1);
        }

        for (int y = 1; y < size + 1; y++) {
            for (int x = 1; x < size + 1; x++) {
                if (matrix[y][x] == map.getEmptyChar()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getEmptyColor()));
                } else if (matrix[y][x] == map.getPlayerChar()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getPlayerColor()));
                } else if (matrix[y][x] == map.getGoalChar()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getGoalColor()));
                } else if (matrix[y][x] == map.getWallChar()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getWallColor()));
                } else if (matrix[y][x] == map.getEnemyChar()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(map.getEnemyColor()));
                }

                coloredPrinter.print(matrix[y][x]);

            }

            System.out.println();

        }

    }

}
