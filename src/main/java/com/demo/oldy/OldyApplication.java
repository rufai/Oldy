package com.demo.oldy;

import com.demo.oldy.entity.Student;
import com.demo.oldy.repository.StudentRepository;
import com.demo.oldy.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OldyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldyApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService, StudentRepository studentRepository) {
        return args -> {
            for (int i = 0; i < 50; i++) {
                studentRepository.save(
                        Student.builder()
                                .firstname("Test" + i)
                                .lastname("Check" + i)
                                .age(i)
                                .build()

                ).subscribe();
            }
        };
    }

}
