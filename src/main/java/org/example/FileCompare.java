package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileCompare {

    public static final String DELIMITER = "\\|";

    public void readFileLines(String filename) {
       /* List<String> lines = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // return lines;
    }

    public void readFileLines() {
       /* List<String> lines = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Path filePath1 = Paths.get(getClass().getResource("/files/week1.dat").getPath());
        Path filePath2 = Paths.get(getClass().getResource("/files/week2.dat").getPath());
        try (BufferedReader reader1 = Files.newBufferedReader(filePath1);
             BufferedReader reader2 = Files.newBufferedReader(filePath2)) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNum = 1;

            while (line1 != null || line2 != null) {
                if (!Objects.equals(line1, line2)) {
                    System.out.println("Difference in line " + lineNum + ":");
                    System.out.println("< " + line1);
                    System.out.println("> " + line2);
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        Path filePath1 = Paths.get(getClass().getResource("/files/a_tower_New/RA.dat").getPath());
        Path filePath2 = Paths.get(getClass().getResource("/files/a_tower_Old/RA.dat").getPath());
        Map<String, String> map = new HashMap<>();
        File outputFile = new File("result.dat");
        try (BufferedReader reader1 = Files.newBufferedReader(filePath1);
             BufferedReader reader2 = Files.newBufferedReader(filePath2);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){

            String line;
            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                String key = parts[4]; // assuming 'key' is the third column
                map.put(key, line);
            }
            int Numlines = 0;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                String key = parts[4];
                if (!map.containsKey(key)) {
                    System.out.println("No.of Lines: "+Numlines++ +" present in file2.dat but not in file1.dat:----"+line);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        FileCompare fileCompare = new FileCompare();
        fileCompare.process();


    }

    public static void printDelta(List<String> list1, List<String> list2) {
        list1.stream()
                .filter(line -> !list2.contains(line))
                .forEach(System.out::println);
    }

}