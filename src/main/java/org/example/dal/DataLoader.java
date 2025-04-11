package org.example.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Record;

@Component
public class DataLoader {

  /*  @Autowired
    private RecordDAO recordDAO;

    public void run(String fileName) throws Exception {
        List<Record> records = new ArrayList<>();
        recordDAO.saveAll(records);
    }*/

    private List<Record> readFileLines(String filename) {
        List<Record> records = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and create a Record object
                Record record = parseLineToRecord(line);
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private Record parseLineToRecord(String line) {
        // Implement the logic to parse a line and create a Record object
        // This is a placeholder implementation
        Record record = new Record();
        // Set the fields of the record object
        return record;
    }
}
