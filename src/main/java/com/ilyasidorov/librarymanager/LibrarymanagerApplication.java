package com.ilyasidorov.librarymanager;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Student;
import com.ilyasidorov.librarymanager.service.BookService;
import com.ilyasidorov.librarymanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class LibrarymanagerApplication {
    
    public static void main(String[] args) {
        
        SpringApplication.run(LibrarymanagerApplication.class, args);
    }

}
