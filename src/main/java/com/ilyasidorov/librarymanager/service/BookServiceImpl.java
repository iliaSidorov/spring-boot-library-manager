package com.ilyasidorov.librarymanager.service;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Book.Type;
import com.ilyasidorov.librarymanager.domain.Student;
import com.ilyasidorov.librarymanager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findByOrderById() {
        return bookRepository.findByOrderById();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Long countBooks() {
        return bookRepository.count();
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findAllByAuthorEquals(author);
    }

    @Override
    public List<Book> findBooksByType(Type type) {
        return bookRepository.findAllByTypeEquals(type);
    }

    @Override
    public List<Book> findBooksByStudent(String name) {
        return bookRepository.findAllByStudent_Name(name);
    }
}
