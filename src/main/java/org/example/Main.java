package org.example;

import az.code.models.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.models");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().commit();

        System.out.println(em.createQuery("SELECT (e.id,e.first_name) FROM Employees e WHERE e.first_name = :firstName1", Employees.class)
                .setParameter("firstName1", "firstName1")
                .getResultList());
        
//        em.close();
//        emf.close();

//        String url = "jdbc:postgresql://localhost:5432/Employees?user=postgres&password=1234";
//        SessionFactory sessionFactory = new Configuration().configure("persistence.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        EntityManager entityManager = EntityManagerProvider.getEntityManager();
//        entityManager.createQuery();

//        Transaction transaction = session.beginTransaction();
//        List<Employees> employees = session.createQuery("FROM Employees", Employees.class).getResultList();
//        for (Employees employee : employees) {
//            System.out.println("ID: " + employee.getEmployee_id() + ", Name: " + employee.getFirst_name());
//        }
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
    }
}