package com.ty.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Employee {
	
	@Id
	private int employeeId ;
	private String employeeName;
	private LocalDate dateOfJoining;
	private String employeeEmail;
	private String employeePassword ;
	
	@ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name="department_id")
	private Department department ;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="address_id")
	private Address address ;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(joinColumns=@JoinColumn(name="employee_id"),
	  inverseJoinColumns = @JoinColumn(name="project_id"))
     private List<Project> project ;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
	

}
