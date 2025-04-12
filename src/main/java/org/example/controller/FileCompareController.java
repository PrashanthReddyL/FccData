package org.example.controller;

import org.example.model.Record;
import org.example.service.FileCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
    public String getRecords(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             Model model) {
        //Page<Record>
        Pageable pageable = PageRequest.of(page, size);
        Page<Record> records = fileCompareService.findAll(pageable);
        model.addAttribute("data", records.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", records.getTotalPages());
        model.addAttribute("totalItems", records.getTotalElements());
        model.addAttribute("pageSize", size);
        return "result";
        //return records;
    }

    @GetMapping("health")
    public String health() {
        return ResponseEntity.ok().toString();
    }
}