package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.example.domain.StudentsGroup;
import org.example.domain.Subject;
import org.example.domain.Teacher;
import org.example.service.DatabaseFactory;

public class SubjectRepository {
    private final DatabaseFactory FACTORY = new DatabaseFactory();

    public void createNewSubject(String subjectName, Teacher teacher, StudentsGroup group){
        try(EntityManager em = FACTORY.createFactory()) {
            Subject subject = new Subject(subjectName, teacher, group);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(subject);
            transaction.commit();
        }
    }
}
