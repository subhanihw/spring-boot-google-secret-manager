package com.nobita.microservices.samplerestapi.services;

import com.nobita.microservices.samplerestapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private static List<Student> STUDENT_LIST = new ArrayList<>();
    static {
        STUDENT_LIST.add(new Student(1, "Naruto", "CSE"));
        STUDENT_LIST.add(new Student(2, "Nobita", "CSE"));
        STUDENT_LIST.add(new Student(3, "Kakashi", "ECE"));
        STUDENT_LIST.add(new Student(4, "Sasuke", "ECE"));
    }
    public List<Student> getAllStudents() {
        return STUDENT_LIST;
    }

    public Optional<Student> getStudentById(int id) {
        return STUDENT_LIST.stream().filter(student -> student.getId()==id).findFirst();
    }

    public Student addStudent(Student student) {
        student.setId(STUDENT_LIST.size()+1);
        STUDENT_LIST.add(student);
        return student;
    }

    public void deleteStudentById(int id) {
        STUDENT_LIST.removeIf(student -> student.getId() == id);
    }
}
