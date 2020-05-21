package task;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream moviesInputStream = Files.newInputStream(
                    Path.of("movies-mpaa.txt")
            );
            var explorer = new MoviesExplorer(moviesInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
