package org.example.persons;

import org.example.subjects.Subject;

public class Teacher extends Person{
    Subject[] subjects;

    public Teacher(String firstName, String lastName, Subject... subjects) {
        super(firstName, lastName);
        this.subjects = subjects;
    }
}
