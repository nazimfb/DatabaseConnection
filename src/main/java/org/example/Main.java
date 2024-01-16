package org.example;

import az.code.models.Employees;
import az.code.models.Jobs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws SQLException{

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.models");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().commit();

        List<Jobs> jobsList = em.createQuery("SELECT (j.jobTitle, (j.maxSalary-j.minSalary)) " +
                "FROM Jobs j " +
                "WHERE j.maxSalary < 18000" +
                " AND j.maxSalary > 12000", Jobs.class).getResultList();
        System.out.println(jobsList);

        List<Employees> employees = em.createQuery("SELECT NEW Employees(e.id,e.first_name,e.last_name,e.email,e.phone_number,e.hire_date,e.job,e.salary,e.manager,e.employeesList,e.department) " +
                        "FROM Employees e " +
                        "WHERE e.first_name = :firstName1", Employees.class)
                .setParameter("firstName1", "firstName1")
                .getResultList();
        System.out.println(employees);

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