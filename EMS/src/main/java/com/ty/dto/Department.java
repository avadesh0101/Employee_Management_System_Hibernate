package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private int departmentId ;
	private long departmentPhoneNumber ;
	private String departmentName ;
	private String departmentLocation ;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employee ;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public long getDepartmentPhoneNumber() {
		return departmentPhoneNumber;
	}

	public void setDepartmentPhoneNumber(long departmentPhoneNumber) {
		this.departmentPhoneNumber = departmentPhoneNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	

}
