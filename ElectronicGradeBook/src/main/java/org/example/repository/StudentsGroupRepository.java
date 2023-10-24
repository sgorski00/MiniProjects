package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.domain.Student;
import org.example.domain.StudentsGroup;
import org.example.service.DatabaseFactory;

public class StudentsGroupRepository {
    private final DatabaseFactory FACTORY = new DatabaseFactory();

    public void createNewStudentsGroup(String groupName){
        try(EntityManager em = FACTORY.createFactory()) {
            StudentsGroup studentsGroup = new StudentsGroup(groupName);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(studentsGroup);
            transaction.commit();
        }
    }

    public StudentsGroup findById(int id){
        try(EntityManager em = FACTORY.createFactory()) {
            return em.find(StudentsGroup.class, id);
        }
    }
}
