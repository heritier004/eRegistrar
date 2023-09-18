package com.service;

import com.domain.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.repository.StudentRepository;
import com.serviceInterface.StudentServiceInterface;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements StudentServiceInterface {
    StudentRepository studentRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudentByStudentId(Integer studentId) {
        studentRepo.deleteByStudentId(studentId);
    }

    @Override
    public Student getStudentByStudentId(Integer studentId) {
        return studentRepo.findStudentByStudentId(studentId);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepo.findAll();
    }
}
