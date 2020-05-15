package com.ilyasidorov.librarymanager.repository;

import com.ilyasidorov.librarymanager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByOrderById();

}
