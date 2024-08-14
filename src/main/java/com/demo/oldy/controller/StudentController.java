package com.demo.oldy.controller;

import com.demo.oldy.data.StudentData;
import com.demo.oldy.entity.Student;
import com.demo.oldy.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping( produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public Flux<Student> findByName(@RequestParam String firstName){
        return studentService.findByFirstname(firstName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Student> create(@RequestBody StudentData student){
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        studentService.deleteById(id);
    }



}
