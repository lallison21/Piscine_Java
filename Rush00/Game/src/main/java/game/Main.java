package game;

public class Main {

    public static void main(String[] args) {

        InitGame initGame;
        try {
            initGame = new InitGame(args);
            initGame.run();
        } catch (IllegalParametersException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

    }

}
