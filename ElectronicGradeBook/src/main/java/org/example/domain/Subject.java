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

    @OneToOne(cascade = CascadeType.MERGE)
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.MERGE)
    private StudentsGroup studentsGroup;

    public Subject(String subjectName, Teacher teacher, StudentsGroup studentsGroup) {
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.studentsGroup = studentsGroup;
    }
}
