package game.parser;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import game.IllegalParametersException;

@Parameters(separators = "=")
public class Parser {

    @Parameter(names={"--enemiesCount"}, required = true, validateWith = PositiveInteger.class)
    private int enemiesCount;
    @Parameter(names={"--wallsCount"}, required = true, validateWith = PositiveInteger.class)
    private int wallsCount;
    @Parameter(names={"--size"}, required = true, validateWith = PositiveInteger.class)
    private int size;
    @Parameter(names={"--profile"}, required = true)
    private String profile;

    public Parser(String []args) {

        JCommander.newBuilder()
                .addObject(this)
                .build()
                .parse(args);

        if (checkSize()) {
            throw new IllegalParametersException("Incorrect size");
        }

    }

    private boolean checkSize() {
        return enemiesCount + wallsCount > (size * 4 - 4) / 2 - 1;
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }

    public int getSize() {
        return size;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "Parser{" +
                "enemiesCount=" + enemiesCount +
                ", wallsCount=" + wallsCount +
                ", size=" + size +
                ", profile='" + profile + '\'' +
                '}';
    }

}
