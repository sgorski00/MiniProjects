package org.example.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.domain.Student;
import org.example.domain.StudentsGroup;
import org.example.service.DatabaseFactory;

public class StudentRepository {
    private final DatabaseFactory FACTORY = new DatabaseFactory();

    public void createNewStudent(String firstName, String lastName, StudentsGroup studentsGroup){
        try(EntityManager em = FACTORY.createFactory()) {
            Student student = new Student(firstName, lastName, studentsGroup);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(student);
            transaction.commit();
        }
    }
}
