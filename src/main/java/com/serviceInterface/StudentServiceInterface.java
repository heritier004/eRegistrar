package com.serviceInterface;

import com.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentByStudentId(Integer studentId);
    Student getStudentByStudentId(Integer studentId);
    List<Student> getStudents();
}
