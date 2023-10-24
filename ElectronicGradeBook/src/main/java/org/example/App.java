package org.example;


import org.example.domain.StudentsGroup;
import org.example.repository.StudentRepository;
import org.example.repository.StudentsGroupRepository;

public class App {
    public static void main(String[] args) {
        StudentsGroupRepository repo1 = new StudentsGroupRepository();
        StudentRepository repo = new StudentRepository();
        StudentsGroup group = repo1.findById(2);
        repo.createNewStudent("Michał", "Zdebiak", group);
        System.out.println("Hello");
    }
}