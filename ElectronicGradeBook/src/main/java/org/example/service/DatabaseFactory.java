package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseFactory {

    public EntityManager createFactory(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistence");
        return emf.createEntityManager();
    }
}
