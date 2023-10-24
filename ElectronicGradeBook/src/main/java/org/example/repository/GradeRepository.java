package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.domain.Grade;
import org.example.domain.Student;
import org.example.domain.Subject;
import org.example.domain.Teacher;
import org.example.service.DatabaseFactory;

public class GradeRepository {
    private final DatabaseFactory FACTORY = new DatabaseFactory();

    public void createNewGrade(Student student, Subject subject, Teacher teacher, int grade){
        Grade newGrade = new Grade(student, subject, teacher, grade);
        try(EntityManager em = FACTORY.createFactory()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(newGrade);
            transaction.commit();
        }
    }
}
