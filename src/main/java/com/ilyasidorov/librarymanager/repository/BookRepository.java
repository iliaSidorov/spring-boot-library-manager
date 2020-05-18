package com.ilyasidorov.librarymanager.repository;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Book.Type;
import com.ilyasidorov.librarymanager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByOrderById();
    List<Book> findAllByAuthorEquals(String author);
    List<Book> findAllByTypeEquals(Type type);
    List<Book> findAllByStudent_Name(String name);
}
