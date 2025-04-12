package org.example.service;

import org.example.dal.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileCompareService {

    private static final String DELIMITER = "\\|";
@Autowired
    DataLoader dataLoader;
    public String process() {
        Path filePath1 = Paths.get(getClass().getResource("/files/a_tower_New/RA.dat").getPath());
        Path filePath2 = Paths.get(getClass().getResource("/files/a_tower_Old/RA.dat").getPath());
        Map<String, String> map = new HashMap<>();
        File outputFile = new File("result.dat");
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader1 = Files.newBufferedReader(filePath1);
             BufferedReader reader2 = Files.newBufferedReader(filePath2);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                String key = parts[4]; // assuming 'key' is the third column
                map.put(key, line);
            }
            int numLines = 0;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                String key = parts[4];
                if (!map.containsKey(key)) {
                    numLines++;
                   // System.out.println("No.of Lines: " + numLines + " present in file2.dat but not in file1.dat:----" + line);
                    result.append("No.of Lines: ").append(numLines).append(" present in file2.dat but not in file1.dat:----").append(line).append("\n");
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    public void load() {
        try {
            Path path = Paths.get("result.dat");
            dataLoader.save(path.toFile());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}