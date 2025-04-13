package org.example.controller;

import org.example.model.Record;
import org.example.service.FileCompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("/dat")
public class FileCompareController {

    @Autowired
    private FileCompareService fileCompareService;

    //private final Path fileLocation;

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
        //model.addAttribute("currentPage", page);
       // model.addAttribute("totalPages", records.getTotalPages());
        model.addAttribute("totalItems", records.getTotalElements());
        model.addAttribute("currentPage", records != null ? records.getNumber() : 0);
        model.addAttribute("totalPages", records != null ? records.getTotalPages() : 1);
        model.addAttribute("pageSize", size);
        return "result";
        //return records;
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile() throws IOException {
        Resource resource = new UrlResource(Paths.get("result.dat").toUri());

        if (resource.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()));

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("health")
    public String health() {
        return ResponseEntity.ok().toString();
    }
}