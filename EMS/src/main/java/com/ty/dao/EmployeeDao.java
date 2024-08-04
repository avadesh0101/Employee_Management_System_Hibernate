package com.ty.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Address;
import com.ty.dto.Department;
import com.ty.dto.Employee;
import com.ty.dto.Project;

public class EmployeeDao {
	
	static Scanner scanner = new Scanner(System.in);
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avadesh");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
    public Employee saveEmployee(Employee employee , EntityManager em , Department department)
    {
    	em.persist(department);
    	em.persist(employee);
    	
    	return employee ;
    }
    
    
    public Employee updateEmployee(int id)
    {
    	
    	Employee employee = em.find(Employee.class, id);
    	
    	System.out.println("Enter the new password");
    	String password = scanner.next();
    	
    	System.out.println("Enter the new name");
    	String name = scanner.next();
    	
    	employee.setEmployeePassword(password);
    	employee.setEmployeeName(name);
    	
    	et.begin();
    	em.merge(employee);
    	et.commit();
    	
    	return employee ;
    }
    
    
    public Employee deleteEmployee(Employee employee, Address address , EntityManager em)
    {	
    	em.remove(employee);
    	em.remove(address);
    	
    	return employee;
    }
    
    
    public Employee findEmployee(int id)
    {
    	Employee employee = em.find(Employee.class, id);
    	
    	return employee ;
    }
    
    
    public List<Employee> findAllEmployee()
    {  	
    	Query query = em.createQuery("SELECT e FROM Employee e");
    	
    	List<Employee> employee = query.getResultList();
    	
    	return employee ;
    }
    
    
    public Department getEmployee(int id)
    {
    	Employee employee = em.find(Employee.class, id);
    	
    	Department department = employee.getDepartment();
    	
    	return department ;
    }
    
    
    public List<Project> getProject(int id)
    {
    	Employee employee = em.find(Employee.class, id);
    	
    	List<Project> project = employee.getProject();
    	
    	return project ;
    }
    
    public Address getAddress(int id)
    {
    	Employee employee = em.find(Employee.class, id);
    	
    	return employee.getAddress() ;
    }
    
    

}
