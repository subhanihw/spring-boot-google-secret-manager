package com.nobita.microservices.samplerestapi.repository;

import com.nobita.microservices.samplerestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
