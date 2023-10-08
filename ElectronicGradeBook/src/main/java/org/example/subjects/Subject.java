package org.example.subjects;

import org.example.persons.Student;
import org.example.persons.Teacher;

import java.util.List;

public abstract class Subject {
    private final String name;
    private Teacher teacher;
    private List<Student> listOfStudents;

    public Subject(String name, Teacher teacher, Student... students){
        this.name = name;
        this.teacher = teacher;
        this.listOfStudents = List.of(students);
    }

    public Teacher teacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> listOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
