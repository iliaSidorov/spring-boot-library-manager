package com.ilyasidorov.librarymanager.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book title cannot be empty")
    private String title;

    @NotBlank(message = "Book author cannot be empty")
    private String author;

    @NotNull(message = "Cannot be empty")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Student student;

    public enum Type {
        EDUCATION, FICTION, NON_FICTION;
    }


}
