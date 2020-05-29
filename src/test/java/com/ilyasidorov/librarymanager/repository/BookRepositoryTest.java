package com.ilyasidorov.librarymanager.repository;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.service.BookService;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @ClassRule
    public static MySQLContainer mySQLContainer =
            new MySQLContainer("mysql:8")
                    .withDatabaseName("librarymanager")
                    .withUsername("librarian")
                    .withPassword("librarian");

    @Autowired
    private BookService bookService;





}
