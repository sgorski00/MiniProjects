package org.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name="subjects")
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name="subject_name", nullable = false)
    private String subjectName;

    @OneToOne
    private Teacher teacher;
}
