package org.example.subjects;

import org.example.persons.Student;
import org.example.persons.Teacher;

public class English extends Subject{
    public English(Teacher teacher, Student... students) {
        super("English", teacher, students);
    }
}
