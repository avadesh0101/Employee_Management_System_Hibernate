package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Employee;
import com.ty.dto.Project;

public class ProjectDao {
	
    static Scanner scanner = new Scanner(System.in);
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avadesh");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	
	public Project saveProject(EntityManager em , Project project , Employee employee , EntityTransaction et)
	{
		et.begin();
		em.persist(project);
		em.persist(employee);
		et.commit();
		
		return project ;
	}
	
	
	public Project updateProject(int id)
	{
		
		Project project = em.find(Project.class, id);
		
		System.out.println("Enter the new project name");
		String newProjectName = scanner.next();
		
		project.setProjectName(newProjectName);
		
		et.begin();
		em.merge(project);
		et.commit();
		
		return project ;
	}
	
	
	public Project deleteProject(int id)
	{
	 
       Project project = em.find(Project.class,id );
	   
	   et.begin();
	   em.remove(project);
	   et.commit();
	   
	   return project ;
	}
	
	
	public Project findProject(int id)
	{
		Project project = em.find(Project.class, id);
		
		return project ;
	}
	
	
	public List<Project> findAllProject()
	{
		Query query = em.createQuery("SELECT p FROM Project p");
		
		List<Project> al = query.getResultList();
		
		return al ;
	}
	
	public List<Employee> getEmployee(int id)
	{
		Project project = em.find(Project.class, id);
		
		List<Employee> employee = project.getEmployee();
		
		return employee ;
	}
	
}
