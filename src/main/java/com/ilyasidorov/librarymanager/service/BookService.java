package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> findByOrderById();
    Optional<Book> getBookById(Long id);
    void saveBook(Book book);
    void deleteBook(Long id);


}
