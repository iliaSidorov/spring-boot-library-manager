package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Book.Type;
import com.ilyasidorov.librarymanager.domain.Student;
import com.ilyasidorov.librarymanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findByOrderById());
        model.addAttribute("count", bookService.countBooks());
        return "allBooks";
    }

    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id).orElse(new Book());
        model.addAttribute("book", book);
        return "bookInfo";
    }

    //add book
    @GetMapping("/add")
    public String getAddBookForm(Model model) {
        model.addAttribute("types", convertTypeToList());
        return "addBookForm";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    //edit book
    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id).orElse(new Book());
        model.addAttribute("book", book);
        model.addAttribute("types", convertTypeToList());
        return "editBookForm";
    }

    //delete book by its id
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    //get all books by selected author
    @GetMapping("/booksByAuthor/{author}")
    public String getBooksByAuthor(@PathVariable("author") String author, Model model) {
        model.addAttribute("books", bookService.findBooksByAuthor(author));
        return "booksByAuthor";
    }

    //get all books by selected type


    //get all books taken by this student
    @GetMapping("/booksByStudent/{name}")
    public String getBooksByStudent(@PathVariable("name") String name, Model model) {
        model.addAttribute("books", bookService.findBooksByStudent(name));
        return "debts";
    }

    //convert the values of the enum Type to list of String
    private List<String> convertTypeToList() {
        return Arrays.stream(Type.values())
                .map(Type::name)
                .collect(Collectors.toList());
    }

}
