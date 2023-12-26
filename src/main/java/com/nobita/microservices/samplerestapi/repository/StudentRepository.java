package com.nobita.microservices.samplerestapi.repository;

import com.nobita.microservices.samplerestapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
