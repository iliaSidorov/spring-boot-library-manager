package com.ilyasidorov.librarymanager.controller;

import com.ilyasidorov.librarymanager.domain.Book;
import com.ilyasidorov.librarymanager.domain.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class ControllerUtils {

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    static List<String> convertYearToList() {
        return Arrays.stream(Student.Year.values())
                .map(Student.Year::name)
                .collect(Collectors.toList());
    }

    static List<String> convertTypeToList() {
        return Arrays.stream(Book.Type.values())
                .map(Book.Type::name)
                .collect(Collectors.toList());
    }
}
