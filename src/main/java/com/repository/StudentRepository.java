package com.repository;

import com.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByStudentId(Integer studentId);
    Student deleteByStudentId(Integer studentId);
}
