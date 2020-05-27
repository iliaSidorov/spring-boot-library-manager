package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;


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
        model.addAttribute("types", bookService.convertTypeToList());
        return "addBookForm";
    }

        //note: Model model in arg-list must locate after bindingResult
    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("book", book);
            return "addBookForm";
        } else {
            bookService.saveBook(book);
        }
        return "redirect:/books";
    }

    //edit book
    @GetMapping("/edit/{id}")
    public String getBookEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id).orElse(new Book());
        model.addAttribute("book", book);
        model.addAttribute("types", bookService.convertTypeToList());
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



}
