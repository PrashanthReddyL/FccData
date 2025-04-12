package org.example.controller;

import org.example.model.Record;
import org.example.service.FileCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/dat")
public class FileCompareController {

    @Autowired
    private FileCompareService fileCompareService;

    @GetMapping("/compare")
    public String compareFiles() {
        return fileCompareService.process();
    }

    @GetMapping("/load")
    public void load() {
        fileCompareService.load();
    }

    @GetMapping("/data")
    public Page<Record> getRecords(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fileCompareService.findAll(pageable);
    }

    @GetMapping("/health")
    public String health() {
        return ResponseEntity.ok().toString();
    }
}