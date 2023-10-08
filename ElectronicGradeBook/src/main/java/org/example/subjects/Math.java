package org.example.subjects;

import org.example.persons.Student;
import org.example.persons.Teacher;

public class Math extends Subject{
    public Math(Teacher teacher, Student... students) {
        super("Math", teacher, students);
    }
}
