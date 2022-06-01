package com.doczilla.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private int id;
    private String name;
    private String surname;


}
