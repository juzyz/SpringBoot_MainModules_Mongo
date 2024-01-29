package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter

@Document(collection = "student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";

    @Id
//    @Indexed(unique=true) // for String UUID
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student( Integer  id, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name, String email, LocalDate dateOfBirth ) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
