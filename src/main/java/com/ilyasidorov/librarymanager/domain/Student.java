package com.ilyasidorov.librarymanager.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Faculty cannot be empty")
    private String faculty;

    @NotNull(message = "Year cannot be empty")
    @Enumerated(EnumType.STRING)
    private Year year;

    @OneToMany(mappedBy = "student")
    private Set<Book> takenBooks = new HashSet<>();

    public enum Year {
        FIRST, SECOND, THIRD, FOURTH, FIFTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
