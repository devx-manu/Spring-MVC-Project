package dao;

import java.util.List;

import dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(Student student) {

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Data Inserted Successfully");
	}
	
	public Student fetchById(int id) {
		entityTransaction.begin();
		Student student=entityManager.find(Student.class, id);
		entityTransaction.commit();
		System.out.println("data fetched successfully");
		System.out.println(student);
		return student;
		
	}
	
	public String deleteById(int id) {
		entityTransaction.begin();
		Student student=entityManager.find(Student.class, id);
		if(student!=null)
		{
		entityManager.remove(student);
		entityTransaction.commit();
		return "data deleted";
		}else {
			return "no data to delete on this id";
		}
	}
	
	public List<Student> fetchAll() {
		entityTransaction.begin();
		Query s=entityManager.createQuery("select data from Student data");
		List<Student> list=s.getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
	
	public String deletAll() {
		entityTransaction.begin();
		Query s=entityManager.createQuery("select data from Student data");
		List<Student> list=s.getResultList();
		if(!list.isEmpty()) {
		for(Student std : list) {
			entityManager.remove(std);
		}
		entityTransaction.commit();
		return "data deleted";
		}else {
			return "No data to delete";
		}
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	}

}
