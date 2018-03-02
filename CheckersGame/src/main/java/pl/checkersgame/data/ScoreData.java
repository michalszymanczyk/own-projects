package pl.checkersgame.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreData {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static ScoreData instance = new ScoreData();
    private static String filename = "Scores.txt";

    Map<Integer, TreeSet> rank = new HashMap<>();

    private ScoreData() {
    }

    public void loadScores() throws IOException {
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String line = null;

        try {
            while ((line = br.readLine()) != null){
                String[] rank = line.split("\t");


            }
        } finally {
            if(br != null) {
                br.close();
            }
        }


    }

    public void storeRank() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {

        } finally {

        }
    }
}
