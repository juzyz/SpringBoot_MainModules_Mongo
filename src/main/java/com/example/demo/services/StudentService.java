package com.example.demo.services;

import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.StudentNotFoundException;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.repositories.sequence.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SequenceGeneratorService seqGeneratorService;

    @Autowired
    public StudentService(StudentRepository studentRepository, SequenceGeneratorService seqGeneratorService) {
        this.studentRepository = studentRepository;
        this.seqGeneratorService = seqGeneratorService;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new BadRequestException("Email " + student.getEmail() + " taken");
        }
        student.setId(seqGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "student with id " + studentId + " does not exist"));
        studentRepository.deleteById(studentId);
    }

    //    @Transactional // for multiple updates to assure they happen all-or-none.
    public void updateStudent(@PathVariable("studentId")  Integer studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "student with id " + studentId + " does not exist")
                );
        if (name != null && name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}
