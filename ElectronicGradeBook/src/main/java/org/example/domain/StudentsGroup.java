package org.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name="classes")
public class StudentsGroup {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name="class_name", nullable = false)
    private String className;

    @OneToOne(cascade = CascadeType.MERGE)
    private Teacher tutor;

    public StudentsGroup(){}

    public StudentsGroup(String className) {
        this.className = className;
    }

    public String className() {
        return className;
    }
}
