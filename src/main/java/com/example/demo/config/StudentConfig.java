package com.example.demo.config;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    // Spring runs CommandLineRunner bean when Spring Boot App starts
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student piter = new Student(1L, "Piter", "piter.smith@gmail.com",
                    LocalDate.of(2005, Month.MAY, 17));

            Student alex = new Student(1L, "Alex", "alex.spenser@gmail.com",
                    LocalDate.of(2003, Month.NOVEMBER, 25));
            repository.saveAll(
                    List.of(piter, alex)
            );
        };
    }
}
