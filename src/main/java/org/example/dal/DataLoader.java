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

    public  List<Record> readFileLines(String filename) {
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

        String[] fields = line.split("\\|");
        Record record = new Record();

        record.setRecordType(getFieldValue(fields, 0));
        record.setContentIndicator(getFieldValue(fields, 1));
        record.setFileNumber(getFieldValue(fields, 2));
        record.setRegistrationNumber(getFieldValue(fields, 3));
        record.setUniqueSystemIdentifier(getFieldValue(fields, 4));
        record.setApplicationPurpose(getFieldValue(fields, 5));
        record.setPreviousPurpose(getFieldValue(fields, 6));
        record.setInputSourceCode(getFieldValue(fields, 7));
        record.setStatusCode(getFieldValue(fields, 8));
        record.setDateEntered(getFieldValue(fields, 9));
        record.setDateReceived(getFieldValue(fields, 10));
        record.setDateIssued(getFieldValue(fields, 11));
        record.setDateConstructed(getFieldValue(fields, 12));
        record.setDateDismantled(getFieldValue(fields, 13));
        record.setDateAction(getFieldValue(fields, 14));
        record.setArchiveFlagCode(getFieldValue(fields, 15));
        record.setVersionInteger(parseIntegerField(fields, 16));
        record.setSignatureFirstName(getFieldValue(fields, 17));
        record.setSignatureMiddleInitial(getFieldValue(fields, 18));
        record.setSignatureLastName(getFieldValue(fields, 19));
        record.setSignatureSuffix(getFieldValue(fields, 20));
        record.setSignatureTitle(getFieldValue(fields, 21));
        record.setInvalidSignature(getFieldValue(fields, 22));
        record.setStructureStreetAddress(getFieldValue(fields, 23));
        record.setStructureCity(getFieldValue(fields, 24));
        record.setStructureState(getFieldValue(fields, 25));
        record.setCountyCode(getFieldValue(fields, 26));
        record.setZipCodeVarchar(getFieldValue(fields, 27));
        record.setHeightOfStructure(getFieldValue(fields, 28));
        record.setGroundElevation(getFieldValue(fields, 29));
        record.setOverallHeightAboveGround(getFieldValue(fields, 30));
        record.setOverallHeightAmsl(getFieldValue(fields, 31));
        record.setStructureType(getFieldValue(fields, 32));
        record.setDateFaaDeterminationIssued(getFieldValue(fields, 33));
        record.setFaaStudyNumber(getFieldValue(fields, 34));
        record.setFaaCircularNumber(getFieldValue(fields, 35));
        record.setSpecificationOption(getFieldValue(fields, 36));
        record.setPaintingAndLighting(getFieldValue(fields, 37));
        record.setProposedMarkingAndLighting(getFieldValue(fields, 38));
        record.setMarkingAndLightingOther(getFieldValue(fields, 39));
        record.setFaaEmiFlag(getFieldValue(fields, 40));
        record.setNepaFlag(getFieldValue(fields, 41));
        record.setDateSigned(getFieldValue(fields, 42));
        record.setAssignorSignatureLastName(getFieldValue(fields, 43));
        record.setAssignorSignatureFirstName(getFieldValue(fields, 44));
        record.setAssignorSignatureMiddleInitial(getFieldValue(fields, 45));
        record.setAssignorSignatureSuffix(getFieldValue(fields, 46));
        record.setAssignorSignatureTitle(getFieldValue(fields, 47));
        record.setAssignorDateSigned(getFieldValue(fields, 48));
        return record;
    }

    // Helper methods
    private String getFieldValue(String[] fields, int index) {
        return (index < fields.length && fields[index] != null && !fields[index].isEmpty()) ? fields[index] : null;
    }

    private int parseIntegerField(String[] fields, int index) {
        return (index < fields.length && fields[index] != null && !fields[index].isEmpty()) ? Integer.parseInt(fields[index]) : 0;
    }

   /* public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        List<Record> records = dataLoader.readFileLines("files/a_tower_New/RA.dat");
        for (Record record : records) {
            System.out.println(record);
        }
    }*/
}
