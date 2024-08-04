package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Address;
import com.ty.dto.Employee;
import com.ty.dto.Project;

public class AddressDao {

	static Scanner scanner = new Scanner(System.in);

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avadesh");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public Address saveAddress(Address address , EntityManager em) {
		em.persist(address);
		
		return address;
	}

	public Address updateAddress(int id) {

		Address address = em.find(Address.class, id);

		System.out.println("Enter the new address");
		String newAddress = scanner.next();
	
		address.setStreet(newAddress);

		et.begin();
		em.merge(address);
		et.commit();

		return address;
	}

	public Address deleteAddress(int id) {

		Address address = em.find(Address.class, id);

		et.begin();
		em.remove(address);
		et.commit();

		return address;
	}

	public Address findAddress(int id) {
		Address address = em.find(Address.class, id);

		return address;
	}

	public List<Address> findAllAddress() {
		Query query = em.createQuery("SELECT a FROM Address a");

		List<Address> al = query.getResultList();

		return al;
	}
	
	public Employee findEmployee(int id)
	{
		Address address = em.find(Address.class, id);
		
		return address.getEmployee();
	}

}
