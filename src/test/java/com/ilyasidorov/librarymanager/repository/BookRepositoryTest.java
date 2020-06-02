package com.ilyasidorov.librarymanager.repository;
import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.service.BookService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookService bookService;

    @Test
    public void findAllTest() {
        List<Book> books = bookService.findBooksByOrderById();
        assertThat(books.size()).isEqualTo(10);
    }


}
