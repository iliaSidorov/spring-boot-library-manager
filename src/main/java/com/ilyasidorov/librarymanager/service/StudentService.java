package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findByOrderById();
    Optional<Student> getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Long id);
}
