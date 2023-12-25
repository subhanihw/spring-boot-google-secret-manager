package com.nobita.microservices.samplerestapi.services;

import com.nobita.microservices.samplerestapi.repository.StudentRepository;
import com.nobita.microservices.samplerestapi.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {
//    private static List<Student> STUDENT_LIST = new ArrayList<>();
//    static {
//        STUDENT_LIST.add(new Student(1, "Naruto", "CSE"));
//        STUDENT_LIST.add(new Student(2, "Nobita", "CSE"));
//        STUDENT_LIST.add(new Student(3, "Kakashi", "ECE"));
//        STUDENT_LIST.add(new Student(4, "Sasuke", "ECE"));
//    }

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(int id) {
        if (getStudentById(id).isEmpty())
            return;
        studentRepository.delete(getStudentById(id).get());
    }
}
