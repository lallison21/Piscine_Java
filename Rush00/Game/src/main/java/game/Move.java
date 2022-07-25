package game;

import chaselogic.Map;

public class Move {

    private final char[][] matrix;
    private final Integer size;
    private Integer playerY;
    private Integer playerX;
    private final Map map;

    public Move(char[][] matrix, Integer size, Map map) {
        this.matrix = matrix;
        this.size = size;
        this.map = map;
        
        initPlayerCoordinate();
    }

    private void initPlayerCoordinate() {
        for (int y = 1; y < size + 1; y++) {
            for (int x = 1; x < size + 1; x++) {
                if (matrix[y][x] == map.getPlayerChar()) {
                    playerY = y;
                    playerX = x;
                }
            }
        }
    }

    public void up() {
        if (matrix[playerY - 1][playerX] == map.getEmptyChar()) {
            matrix[playerY - 1][playerX] = map.getPlayerChar();
            matrix[playerY][playerX] = map.getEmptyChar();
            playerY = playerY - 1;
        } else if (matrix[playerY - 1][playerX] == map.getGoalChar()) {
            System.out.println("You win");
            System.exit(0);
        } else if (matrix[playerY - 1][playerX] == map.getEnemyChar()) {
            System.out.println("Game over");
            System.exit(0);
        }
    }

    public void down() {
        if (matrix[playerY + 1][playerX] == map.getEmptyChar()) {
            matrix[playerY + 1][playerX] = map.getPlayerChar();
            matrix[playerY][playerX] = map.getEmptyChar();
            playerY = playerY + 1;
        } else if (matrix[playerY + 1][playerX] == map.getGoalChar()) {
            System.out.println("You win");
            System.exit(0);
        } else if (matrix[playerY + 1][playerX] == map.getEnemyChar()) {
            System.out.println("Game over");
            System.exit(0);
        }
    }

    public void left() {
        if (matrix[playerY][playerX - 1] == map.getEmptyChar()) {
            matrix[playerY][playerX - 1] = map.getPlayerChar();
            matrix[playerY][playerX] = map.getEmptyChar();
            playerX = playerX - 1;
        } else if (matrix[playerY][playerX - 1] == map.getGoalChar()) {
            System.out.println("You win");
            System.exit(0);
        } else if (matrix[playerY][playerX - 1] == map.getEnemyChar()) {
            System.out.println("Game over");
            System.exit(0);
        }
    }

    public void right() {
        if (matrix[playerY][playerX + 1] == map.getEmptyChar()) {
            matrix[playerY][playerX + 1] = map.getPlayerChar();
            matrix[playerY][playerX] = map.getEmptyChar();
            playerX = playerX + 1;
        } else if (matrix[playerY][playerX + 1] == map.getGoalChar()) {
            System.out.println("You win");
            System.exit(0);
        } else if (matrix[playerY][playerX + 1] == map.getEnemyChar()) {
            System.out.println("Game over");
            System.exit(0);
        }
    }
}
