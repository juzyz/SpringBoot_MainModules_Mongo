package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
@Tag(name = "Student Controller API")
@SecurityRequirement(name = "bearerAuthentication")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Fetch all students stored in DB",
            description = "Some extend description of this endpoint"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetch all students from DB",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403",
                    description = "Forbidden/ Invalid Token",
                    content = @Content)
    })
    @GetMapping
    public List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @Operation(summary = "Create a new student",
            description = "Add a new student to DB" )
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @Operation(summary = "Delete the student by id",
            description = "Remove the student from DB")
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @Operation(summary = "Update the student by id",
            description = "Update the student in DB")
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,  // sent parameter via URL Parameters
                              @RequestParam(required = false) String email,
                              @RequestBody Student student  // or parse parameters from json of request body
    ) {
        studentService.updateStudent(studentId, name, email);
    }

}
