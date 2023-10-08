package org.example.subjects;

import org.example.persons.Student;
import org.example.persons.Teacher;

public class History extends Subject{
    public History(Teacher teacher, Student... students) {
        super("History", teacher, students);
    }
}
