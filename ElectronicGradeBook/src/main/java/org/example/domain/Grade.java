package org.example.domain;

import jakarta.persistence.*;
import org.example.NumberValidator;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="grades")
public class Grade {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Student student;

    @OneToOne(cascade = CascadeType.MERGE)
    private Subject subject;

    @OneToOne(cascade = CascadeType.MERGE)
    private Teacher teacher;

    @Column(name="grade", nullable = false)
    private int grade;

    @Column(name="date")
    private Date introductionDate;

    public Grade(Student student, Subject subject, Teacher teacher, int grade) {
        if(NumberValidator.isNumberInRange(grade, 1, 6)) {
            this.student = student;
            this.subject = subject;
            this.teacher = teacher;
            this.grade = grade;
            this.introductionDate = java.sql.Date.from(Instant.now());
        }else{
            throw new IllegalArgumentException("Wrong grade.");
        }
    }
}
