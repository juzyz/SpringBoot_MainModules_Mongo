package com.example.demo.repositories;

import com.example.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    Optional<Student> findStudentByEmail(String email);
}
