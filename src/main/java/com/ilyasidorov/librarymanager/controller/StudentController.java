package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.Student;
import com.ilyasidorov.librarymanager.domain.Student.Year;
import com.ilyasidorov.librarymanager.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
        model.addAttribute("years", convertYearToList());
        return "addStudentForm";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    //edit student
    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(new Student());
        model.addAttribute("student", student);
        model.addAttribute("years", convertYearToList());
        return "editStudentForm";
    }

    //delete student by its id
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    //convert the values of the enum Year to list of String
    private List<String> convertYearToList() {
        return Arrays.stream(Year.values())
                .map(Year::name)
                .collect(Collectors.toList());
    }
}
