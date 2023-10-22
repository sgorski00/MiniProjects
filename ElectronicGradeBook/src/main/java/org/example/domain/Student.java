package org.example.domain;

import jakarta.persistence.*;
import org.example.NumberCheck;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne
    private StudentsGroup group;

    public Student(String firstName, String lastName, StudentsGroup group) {
        if(NumberCheck.doesContainsNumber(firstName) || NumberCheck.doesContainsNumber(lastName)){
            throw new IllegalArgumentException("First or last name is empty");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
        }
    }


}
