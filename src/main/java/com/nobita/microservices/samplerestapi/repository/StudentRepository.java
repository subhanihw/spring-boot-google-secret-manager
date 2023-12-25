package com.nobita.microservices.samplerestapi.repository;

import com.nobita.microservices.samplerestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
