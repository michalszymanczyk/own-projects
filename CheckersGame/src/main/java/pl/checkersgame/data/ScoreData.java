package pl.checkersgame.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScoreData {

    private static ScoreData instance = new ScoreData();
    private static String filename = "Scores.txt";

    private ScoreData() {
    }

    public void loadScores() throws IOException {
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);


    }
}
