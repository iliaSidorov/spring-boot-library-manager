package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Student;
import com.ilyasidorov.librarymanager.domain.Student.Year;
import com.ilyasidorov.librarymanager.service.BookService;
import com.ilyasidorov.librarymanager.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final BookService bookService;

    public StudentController(StudentService studentService, BookService bookService) {
        this.studentService = studentService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findByOrderById());
        return "allStudents";
    }

    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(new Student());
        model.addAttribute("student", student);
        return "studentInfo";
    }

    //add student
    @GetMapping("/add")
    public String getAddStudentForm(Model model) {
        model.addAttribute("years", ControllerUtils.convertYearToList());
        return "addStudentForm";
    }

    @PostMapping("/add")
    public String addStudent(@Valid Student student,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("student", student);
            return "addStudentForm";
        } else {
            studentService.saveStudent(student);
        }
        return "redirect:/students";
    }

    //edit student
    @GetMapping("/edit/{id}")
    public String getEditStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(new Student());
        model.addAttribute("student", student);
        model.addAttribute("years", ControllerUtils.convertYearToList());
        return "editStudentForm";
    }

    //delete student by its id
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }








}
