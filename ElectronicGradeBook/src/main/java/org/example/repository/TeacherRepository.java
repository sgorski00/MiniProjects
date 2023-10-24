package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.domain.Student;
import org.example.domain.StudentsGroup;
import org.example.domain.Teacher;
import org.example.service.DatabaseFactory;

public class TeacherRepository {
    private final DatabaseFactory FACTORY = new DatabaseFactory();

    public void createNewTeacher(String firstName, String lastName){
        try(EntityManager em = FACTORY.createFactory()) {
            Teacher teacher = new Teacher(firstName, lastName);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(teacher);
            transaction.commit();
        }
    }
}
