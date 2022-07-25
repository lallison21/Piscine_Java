package game;

import java.io.*;
import java.util.Properties;

public class Downloader {

    private final String profile;

    public Downloader(String profile) {
        this.profile = profile;
    }

    public Properties download() throws IOException {

        Properties properties = new Properties();

        String propFileName = String.format("application-%s.properties", profile);

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException(propFileName);
            }
            properties.load(inputStream);
        }

        return properties;
    }
}
