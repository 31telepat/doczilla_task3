package com.doczilla.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, String surname, String patronymic, LocalDate dateOfBorn, String nameOfGroup) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBorn = dateOfBorn;
        this.nameOfGroup = nameOfGroup;
    }

    public Student(int id, String name, String surname, String patronymic, LocalDate dateOfBorn, String nameOfGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBorn = dateOfBorn;
        this.nameOfGroup = nameOfGroup;
    }

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateOfBorn;
    private String nameOfGroup;
}
