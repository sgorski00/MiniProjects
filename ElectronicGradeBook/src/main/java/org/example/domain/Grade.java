package org.example.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="grades")
public class Grade {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @OneToOne
    private Student student;

    @OneToOne
    private Subject subject;

    @OneToOne
    private Teacher teacher;

    @Column(name="grade", nullable = false)
    private int grade;

    @Column(name="date")
    private Date introductionDate;
}
