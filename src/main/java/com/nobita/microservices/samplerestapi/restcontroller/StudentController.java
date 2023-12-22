package com.nobita.microservices.samplerestapi.restcontroller;

import com.nobita.microservices.samplerestapi.Exceptions.UserNotFoundException;
import com.nobita.microservices.samplerestapi.model.Student;
import com.nobita.microservices.samplerestapi.model.dto.AddStudentDTO;
import com.nobita.microservices.samplerestapi.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentService service;

    @Value("${secret}")
    String message;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/secret")
    public String getMessage() {
        return message;
    }

    @GetMapping("v1/students")
    public List<Student> getAllStudent() {
        return (List<Student>) service.getAllStudents();
    }

    @GetMapping("v1/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        Optional<Student> res = service.getStudentById(id);
        if (res.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User Not Found with id = %d", id));
            throw new UserNotFoundException(String.format("User Not Found with id = %d", id));
        }
        else
            return res.get();
    }

    @PostMapping("v1/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody AddStudentDTO student) {
        Student student1 = new Student();
        student1.setBranch(student.getBranch());
        student1.setName(student.getName());
        Student savedStudent = service.addStudent(student1);
        URI location = ServletUriComponentsBuilder
                                    .fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(savedStudent.getId())
                                    .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("v1/students/{id}")
    public void deleteStudentById(@PathVariable int id) {
        Optional<Student> res = service.getStudentById(id);
        if (res.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User Not Found with id = %d", id));
            throw new UserNotFoundException(String.format("User Not Found with id = %d", id));
        }
        else {
            service.deleteStudentById(id);
        }
    }
}
