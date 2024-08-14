package com.demo.oldy.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder
@Table("student")
public class Student {

    @Id
    private int id;
    private String firstname;
    private String lastname;
    private int age;
}
