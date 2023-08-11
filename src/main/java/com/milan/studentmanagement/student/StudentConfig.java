package com.milan.studentmanagement.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository stdrepo) {
        return args -> {
            Student milan = new Student("Milan Kumar Gupta",
            "milangupta95@gmail.com",
            LocalDate.of(2002, Month.JANUARY, 7));
            Student poonam = new Student("Poonam Maurya"
            ,"pmaurya@gmail.com",
            LocalDate.of(2001,Month.AUGUST,14));
            stdrepo.saveAll(List.of(milan,poonam));
        };
    }
}
