package org.example.controller;

    import org.example.service.FileCompareService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

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

        @GetMapping("/health")
        public String health() {
            return ResponseEntity.ok().toString();
        }
    }