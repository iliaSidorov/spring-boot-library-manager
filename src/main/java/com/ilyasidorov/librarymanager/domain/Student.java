package com.ilyasidorov.librarymanager.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "Year cannot be empty")
    @Enumerated(EnumType.STRING)
    private Year year;

    public enum Year {
        FIRST, SECOND, THIRD, FOURTH, FIFTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
