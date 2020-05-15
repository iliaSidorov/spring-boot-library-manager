package com.ilyasidorov.librarymanager.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String faculty;

    @Enumerated(EnumType.STRING)
    private Year year;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public enum Year {
        FIRST, SECOND, THIRD, FOURTH, FIFTH;
    }
}
