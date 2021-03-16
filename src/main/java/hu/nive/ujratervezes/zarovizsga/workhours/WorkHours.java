package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {
        String result = null;
        Path path = Path.of(file);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            result = getString(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    private String getString(BufferedReader br) throws IOException {
        String result = null;
        String line;
        int minHours = 24;
        while ((line = br.readLine()) != null) {
            int actual = Integer.parseInt(line.split(",")[1]);
            if (actual < minHours) {
                minHours = actual;
                result = line.split(",")[0] + ": " + line.split(",")[2];
            }
        }
        return result;
    }
}
