package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Department;
import com.ty.dto.Employee;


public class DepartmentDao {

	static Scanner scanner = new Scanner(System.in);

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avadesh");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	
	public Department saveDepartment(Department department , EntityManager em)
	{
		em.persist(department);
		
		return department ;
	}
	
	
	public Department updateDepartment(int id)
	{
		Department department = em.find(Department.class, id);
		
		System.out.println("Enter new location");
		String newLocation = scanner.next();
		
		department.setDepartmentLocation(newLocation);
		
		et.begin();
		em.merge(department);
		et.commit();
		
		return department ;
	}
	
	
	public Department deleteDepartment(int id)
	{
		Department department = em.find(Department.class, id);
		
		et.begin();
		em.remove(department);
		et.commit();
		
		return department ;
		
	}
	
	
	public Department findDepartment(int id)
	{
		Department department = em.find(Department.class, id);
		
		return department ;
	}
	
	
	public List<Department> findAll()
	{
		Query query = em.createQuery("SELECT d FROM Department d");
		
		List<Department> al = query.getResultList();
		
		return al ;
	}
	
	public List<Employee> getEmployee(int id)
	{
	   Department department = em.find(Department.class , id);
	   
	   List<Employee> employee = department.getEmployee() ;
	   
	   return employee ;
	}

}
