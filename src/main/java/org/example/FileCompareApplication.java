package org.example;

//import org.example.dal.RecordRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
/*@EnableJpaRepositories(basePackages = "org.example", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = RecordRepository.class))*/
public class FileCompareApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileCompareApplication.class, args);
    }
}