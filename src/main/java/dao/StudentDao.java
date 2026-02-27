package dao;

import dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentDao {


public void insert(Student student)
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	System.out.println("Data Inserted Successfully");
}



}
