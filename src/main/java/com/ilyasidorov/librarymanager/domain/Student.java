package com.ilyasidorov.librarymanager.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String name;

    private String faculty;

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
