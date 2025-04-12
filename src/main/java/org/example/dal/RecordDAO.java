package org.example.dal;

import org.example.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RecordDAO {

    @Autowired
    private RecordRepository recordRepository;

    @Transactional
    public void saveAll(List<Record> records) {
        try {
            recordRepository.saveAll(records);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Page<Record> findAll(Pageable pageable) {
        try {
            return recordRepository.findAll(pageable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
