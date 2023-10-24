package org.example.domain;

import jakarta.persistence.*;
import org.example.NumberValidator;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true, nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.MERGE)
    private StudentsGroup group;

    public Teacher(String firstName, String lastName) {
        if(NumberValidator.doesContainsNumber(firstName) || NumberValidator.doesContainsNumber(lastName)){
            throw new IllegalArgumentException("First or last name is empty");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public Teacher(String firstName, String lastName, StudentsGroup group){
        if(NumberValidator.doesContainsNumber(firstName) || NumberValidator.doesContainsNumber(lastName)){
            throw new IllegalArgumentException("First or last name is empty");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
        }
    }
}
