package com.demo.oldy.service;


import com.demo.oldy.data.StudentData;
import com.demo.oldy.entity.Student;
import com.demo.oldy.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

// business logic
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Flux<Student> findAll() {
        return studentRepository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Flux<Student> findByFirstname(String firstName) {
        return studentRepository.findAllByFirstnameContainingIgnoreCase(firstName);
    }

    public Mono<Student> save(StudentData data) {
        return studentRepository.save(
            Student.builder()
                    .firstname(data.getFirstname())
                    .lastname(data.getLastname())
                    .age(data.getAge())
                    .build()
        );
    }

    public Mono<Student> update(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
