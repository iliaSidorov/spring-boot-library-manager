package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Book.Type;
import com.ilyasidorov.librarymanager.domain.Student;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findByOrderById();
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByType(Type type);
    List<Book> findBooksByStudent(String name);
    Optional<Book> getBookById(Long id);
    void saveBook(Book book);
    void deleteBook(Long id);
    Long countBooks();


}
