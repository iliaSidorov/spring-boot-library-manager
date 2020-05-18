package com.ilyasidorov.librarymanager.domain;

import lombok.*;

import javax.persistence.*;
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
