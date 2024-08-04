package com.ty.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.AddressDao;
import com.ty.dao.DepartmentDao;
import com.ty.dao.EmployeeDao;
import com.ty.dao.ProjectDao;
import com.ty.dto.Address;
import com.ty.dto.Department;
import com.ty.dto.Employee;
import com.ty.dto.Project;

public class Controller {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avadesh");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int input = 0;

		while (input != 5) {
			System.out.println("--------------Employee Management System-----------------");
			System.out.println("Press 1 to get Department Information ");
			System.out.println("Press 2 to get Employee Information");
			System.out.println("Press 3 to get Project Information");
			System.out.println("Press 4 to get Address Information");
			System.out.println("Press 5 to exit");

			input = scanner.nextInt();

			switch (input) {
			case 1:
				getDepartment();

				break;

			case 2:
				getEmployee();
				break;

			case 3:
				getProject();
				break;

			case 4:
				getAddress();
				break;
			}
		}

	}

	public static void getDepartment() {

		System.out.println("Press 1 to get employee from department");
		System.out.println("Press 2 to the department");
		System.out.println("Press 3 to find department by id");
		System.out.println("Press 4 to get all the departement information");
		System.out.println("Press 5 to delete department");
		System.out.println("Press 6 to save department details");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {

			System.out.println("Enter the department id to get the employees from department");
			int id = scanner.nextInt();

			DepartmentDao departmentDao = new DepartmentDao();
			List<Employee> al = departmentDao.getEmployee(id);

			if (al != null) {
				for (Employee ele : al) {
					System.out.println("Employee id :" + ele.getEmployeeId());
					System.out.println("Employee id :" + ele.getEmployeeName());
					System.out.println("Employee id :" + ele.getEmployeeEmail());
					System.out.println("Employee id :" + ele.getEmployeePassword());
					System.out.println("Employee id :" + ele.getDateOfJoining());

				}
			} else {
				System.out.println("No employees are working in this department");
			}

		}

			break;

		case 2: {

			System.out.println("Enter the department id you want to update");
			int id = scanner.nextInt();

			DepartmentDao departmentDao = new DepartmentDao();
			Department department = departmentDao.updateDepartment(id);

			if (department != null) {
				System.out.println("Updated Sucessfully");
			} else {
				System.out.println("Failed to update");
			}
		}

			break;

		case 3: {

			System.out.println("Enter the department id you want to find");
			int id = scanner.nextInt();

			DepartmentDao departmentDao = new DepartmentDao();
			Department department = departmentDao.findDepartment(id);

			if (department != null) {
				System.out.println("Department Id :" + department.getDepartmentId());
				System.out.println("Department Name :" + department.getDepartmentName());
				System.out.println("Department Location :" + department.getDepartmentLocation());
				System.out.println("Department PhoneNo :" + department.getDepartmentPhoneNumber());
			} else {
				System.out.println("Failed to find the details");
			}

		}

			break;

		case 4: {
			DepartmentDao departmentDao = new DepartmentDao();
			List<Department> department = departmentDao.findAll();

			for (Department ele : department) {
				System.out.println("Department ID :" + ele.getDepartmentId());
				System.out.println("Department ID :" + ele.getDepartmentName());
				System.out.println("Department ID :" + ele.getDepartmentLocation());
				System.out.println("Department ID :" + ele.getDepartmentPhoneNumber());
				System.out.println("----------------------------------------------");
			}

		}

			break;

		case 5: {

			System.out.println("Enter the department id you want to delete");
			int id = scanner.nextInt();

			DepartmentDao departmentDao = new DepartmentDao();
			Department department = departmentDao.deleteDepartment(id);

			if (department != null) {
				System.out.println("Deleted Sucessfully");
			} else {
				System.out.println("Failed to delete");
			}

		}
			break;

		case 6: {

			Department department = addDepartment();
			department.setEmployee(getEmployess());
			;

			DepartmentDao departmentDao = new DepartmentDao();

			Department returnDepartment = departmentDao.saveDepartment(department, em);

			if (returnDepartment != null) {
				System.out.println("Inserted Sucessfully");
			} else {
				System.out.println("Failed to insert");
			}

		}
		}
	}

	private static List<Employee> getEmployess() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void getEmployee() {

		System.out.println("Press 1 to get department details of the employee");
		System.out.println("Press 2 to get update employee");
		System.out.println("Press 3 to find employee by id");
		System.out.println("Press 4 to get all the employee information");
		System.out.println("Press 5 to delete employee");
		System.out.println("Press 6 to save the employee");
		System.out.println("Press 7 to get project details of the employee");
		System.out.println("Press 8 to get address details of the employee");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the employee id to get department details ");
			int employeeId = scanner.nextInt();

			EmployeeDao employeeDao = new EmployeeDao();

			Department department = employeeDao.getEmployee(employeeId);

			if (department != null) {
				System.out.println("Department Id :" + department.getDepartmentId());
				System.out.println("Department PhoneNumber :" + department.getDepartmentPhoneNumber());
				System.out.println("Department Name :" + department.getDepartmentName());
				System.out.println("Department Location :" + department.getDepartmentLocation());
			} else {
				System.out.println("Failed to get department details");
			}
		}

			break;

		case 2: {

			System.out.println("Enter the employee id to update the information");
			int eId = scanner.nextInt();

			EmployeeDao employeeDao = new EmployeeDao();

			Employee updatedEmployee = employeeDao.updateEmployee(eId);

			if (updatedEmployee != null) {
				System.out.println("Updated Sucessfully");
			} else {
				System.out.println("Failed to update");
			}

		}

			break;

		case 3: {
			System.out.println("Enter the employee id to find the employee");
			int eId = scanner.nextInt();

			EmployeeDao employeeDao = new EmployeeDao();

			Employee findEmployee = employeeDao.findEmployee(eId);

			if (findEmployee != null) {
				System.out.println("Employee Id :" + findEmployee.getEmployeeId());
				System.out.println("Employee Name :" + findEmployee.getEmployeeName());
				System.out.println("Employee DateOfJoining :" + findEmployee.getDateOfJoining());
				System.out.println("Employee Email :" + findEmployee.getEmployeeEmail());
				System.out.println("Employee Password :" + findEmployee.getEmployeePassword());
			}

		}

			break;

		case 4: {

			EmployeeDao employeeDao = new EmployeeDao();

			List<Employee> allEmployee = employeeDao.findAllEmployee();

			for (Employee employee1 : allEmployee) {
				System.out.println("Employee ID :" + employee1.getEmployeeId());
				System.out.println("Employee Name :" + employee1.getEmployeeName());
				System.out.println("Employee DateOfJoining :" + employee1.getDateOfJoining());
				System.out.println("Employee Email :" + employee1.getEmployeeEmail());
				System.out.println("Employee Password :" + employee1.getEmployeePassword());
				System.out.println("----------------------------------------------");
			}

		}

			break;

		case 5: {

			System.out.println("Enter the employee id you want to delete");
			int eId = scanner.nextInt();
			
			et.begin();
			
			Employee employee = em.find(Employee.class, eId);
			
			Address address = employee.getAddress();

			EmployeeDao employeeDao = new EmployeeDao();

			Employee deletedEmployee = employeeDao.deleteEmployee(employee, address , em);
			
			et.commit();

			if (deletedEmployee != null) {
				System.out.println("Deleted employee sucessfully");
			} else {
				System.out.println("Failed to delete");
			}
		}

			break;

		case 6: {

			Employee employee = addEmployee();

			List<Employee> listEmployee = new ArrayList<>();
			listEmployee.add(employee);

			getEmployees(listEmployee);

			et.begin();
			employee.setAddress(addAdress());
			System.out.println("Enter the department id you want to add employee to");
			int dId = scanner.nextInt();
			Department department = em.find(Department.class, dId);
			employee.setDepartment(department);
			department.setEmployee(listEmployee);
			EmployeeDao employeeDao = new EmployeeDao();
			Employee returnEmployee = employeeDao.saveEmployee(employee, em, department);
			et.commit();

			if (returnEmployee != null) {
				System.out.println("Inserted Sucessfully");
			}

		}

			break;

		case 7: {

			System.out.println("Enter the employee id to get the project details");
			int id = scanner.nextInt();

			EmployeeDao employeeDao = new EmployeeDao();

			List<Project> project = employeeDao.getProject(id);

			for (Project ele : project) {
				System.out.println("Project Id :" + ele.getProjectId());
				System.out.println("Project name :" + ele.getProjectName());
				System.out.println("Project Start Date :" + ele.getStartDate());
				System.out.println("Project DeadLine :" + ele.getDeadLine());

			}

		}

			break;

		case 8: {
			System.out.println("Enter the employee id to get the address details");

			int id = scanner.nextInt();

			EmployeeDao employeeDao = new EmployeeDao();

			Address address = employeeDao.getAddress(id);

			if (address != null) {
				System.out.println("Adress Id :" + address.getAddressId());
				System.out.println("City :" + address.getCity());
				System.out.println("Country :" + address.getCountry());
				System.out.println("PinCode :" + address.getPincode());
				System.out.println("State :" + address.getState());
				System.out.println("Street :" + address.getStreet());

			} else {
				System.out.println("Adress not found");
			}
		}
		}

	}

	public static void getProject() {

		System.out.println("Press 1 to get employee details working on the project");
		System.out.println("Press 2 to update project");
		System.out.println("Press 3 to find project by id");
		System.out.println("Press 4 to get all the project information");
		System.out.println("Press 5 to delete project");
		System.out.println("Press 6 to save the poject");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the project id to get employee details working on that project");
			int id = scanner.nextInt();
			
			ProjectDao projectDao = new ProjectDao();
			List<Employee> employee = projectDao.getEmployee(id);
			
			for(Employee ele : employee)
			{
				System.out.println("Employee Id :" +ele.getEmployeeId());
				System.out.println("Employee Name :" +ele.getEmployeeName());
				System.out.println("Employee Password :" +ele.getEmployeePassword());
				System.out.println("Employee Email :" +ele.getEmployeeEmail());
				System.out.println("Employee Date Of Joining :" +ele.getDateOfJoining());
				
			}
		}

			break;

		case 2: {

			System.out.println("Enter project id to update the project");
			int id = scanner.nextInt();
			
			ProjectDao projectDao = new ProjectDao();
			Project project = projectDao.updateProject(id);
			
			if(project!=null)
			{
				System.out.println("Updated Sucessfully");
			}
			else
			{
				System.out.println("Failed to update");
			}

		}

			break;

		case 3: {
			System.out.println("Enter the project id ");
			int id = scanner.nextInt();
			
			ProjectDao projectDao = new ProjectDao();
			
			Project project = projectDao.findProject(id);
			
			if(project!=null)
			{
				System.out.println("Project Id :" +project.getProjectId());
				System.out.println("Project Name :" +project.getProjectName());
				System.out.println("Project StartDate :" +project.getStartDate());
				System.out.println("Project End :" +project.getDeadLine());
				
			}
			else
			{
				System.out.println("Project not found");
			}

		}

			break;

		case 4: {

			ProjectDao projectDao = new ProjectDao();
			
			List<Project> project = projectDao.findAllProject();
			
			for(Project ele : project)
			{
				System.out.println("Project Id :" +ele.getProjectId());
				System.out.println("Project Name :" +ele.getProjectName());
				System.out.println("Project Start date :" +ele.getStartDate());
				System.out.println("Project End Date:" +ele.getDeadLine());
				System.out.println("----------------------------------------------");
			}
		}

			break;

		case 5: {

			System.out.println("Enter the project id you want to delete");
			int id = scanner.nextInt();
			
			ProjectDao projectDao = new ProjectDao();
			
			Project project = projectDao.deleteProject(id);
			
			if(project!=null)
			{
				System.out.println("Deleted Sucessfully");
			}
			else
			{
				System.out.println("Failed to delete");
			}
		}

			break;

		case 6: {
			System.out.println("Enter project id");
			int pId = scanner.nextInt();

			System.out.println("Enter project name");
			String name = scanner.next();

			System.out.println("Enter the start date of project");
			String dateOfStart = scanner.next();

			System.out.println("Enter the project deadline");
			String endDateProject = scanner.next();

			Project project1 = new Project();

			project1.setProjectId(pId);
			project1.setProjectName(name);
			project1.setStartDate(LocalDate.parse(dateOfStart));
			project1.setDeadLine(LocalDate.parse(endDateProject));

			List<Project> project = new ArrayList<>();
			project.add(project1);

			System.out.println("Enter the employee id you want to add to the project");
			int eId = scanner.nextInt();

			Employee employee1 = em.find(Employee.class, eId);

			List<Employee> listEmployee = new ArrayList<>();
			listEmployee.add(employee1);

			employee1.setProject(project);
			project1.setEmployee(listEmployee);

			ProjectDao projectDao = new ProjectDao();

			Project returnProject = projectDao.saveProject(em, project1, employee1, et);

			if (returnProject != null) {
				System.out.println("Inserted Sucessfully");
			} else {
				System.out.println("Failed to insert");
			}

		}
		}

	}

	public static void getAddress() {

		System.out.println("Press 1 to get employee details using address");
		System.out.println("Press 2 to update the address");
		System.out.println("Press 3 to find the address");
		System.out.println("Press 4 to get all the address");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the address id to ger the employee details");
			int id = scanner.nextInt();
			
			AddressDao addressDao = new AddressDao();
			
			Employee employee = addressDao.findEmployee(id);
			
			if(employee!=null)
			{
				System.out.println("Employee Id :" +employee.getEmployeeId());
				System.out.println("Employee Id :" +employee.getEmployeeName());
				System.out.println("Employee Id :" +employee.getEmployeeEmail());
				System.out.println("Employee Id :" +employee.getEmployeePassword());
				System.out.println("Employee Id :" +employee.getDateOfJoining());
			}
			else
			{
				System.out.println("Employee not found");
			}
		}

			break;

		case 2: {

			System.out.println("Enter the address id to update the address");
			
			int id = scanner.nextInt();
			
			AddressDao addressDao = new AddressDao();
			
			Address address = addressDao.updateAddress(id);
			
			if(address!=null)
			{
				System.out.println("Updated Sucessfully");
			}
			else
			{
				System.out.println("Failed to update");
			}
		}

			break;

		case 3: {
			System.out.println("Enter the address id");
			
			AddressDao addressDao = new AddressDao();
			Address address = addressDao.findAddress(scanner.nextInt());
			
			if(address!=null)
			{
				System.out.println("Address Id :" +address.getAddressId());
				System.out.println("Street : " +address.getStreet());
				System.out.println("State :" +address.getState());
				System.out.println("City :" +address.getCity());
				System.out.println("PinCode :" +address.getPincode());
			}
			else
			{
				System.out.println("Failed to find the address");
			}

		}

			break;

		case 4: {

			AddressDao addressDao = new AddressDao();
			
			List<Address> address = addressDao.findAllAddress();
			
			for(Address ele : address)
			{
				System.out.println("Address Id :" +ele.getAddressId());
				System.out.println("Street : " +ele.getStreet());
				System.out.println("State :" +ele.getState());
				System.out.println("City :" +ele.getCity());
				System.out.println("PinCode :" +ele.getPincode());
				System.out.println("-----------------------------------------");
			}

		}

			break;

		case 5: {

			System.out.println("Enter the address id ");
			
			AddressDao addressDao = new AddressDao();
			
			Address address = addressDao.deleteAddress(scanner.nextInt());
			
			if(address!=null)
			{
				System.out.println("Deleted Sucessfully");
			}
			else
			{
				System.out.println("Deleted Sucessfully");
			}
		}

			break;

		
		}

	}

	public static Employee addEmployee() {
		System.out.println("Enter employee id");
		int eId = scanner.nextInt();

		System.out.println("Enter employee name");
		String name = scanner.next();

		System.out.println("Enter the date of joining");
		String dateOfJoining = scanner.next();

		System.out.println("Enter the employee email");
		String email = scanner.next();

		System.out.println("Enter the employee password");
		String password = scanner.next();

		Employee employee = new Employee();

		employee.setEmployeeId(eId);
		employee.setEmployeeName(name);
		employee.setDateOfJoining(LocalDate.parse(dateOfJoining));
		employee.setEmployeeEmail(email);
		employee.setEmployeePassword(password);

		return employee;

	}

	public static Department addDepartment() {
		System.out.println("Enter  department id");
		int dId = scanner.nextInt();

		System.out.println("Enter department phoneNo");
		long phone = scanner.nextLong();

		System.out.println("Enter the department name");
		String dName = scanner.next();

		System.out.println("Enter the department location");
		String dLocation = scanner.next();

		Department department = new Department();

		department.setDepartmentId(dId);
		department.setDepartmentName(dName);
		department.setDepartmentLocation(dLocation);
		department.setDepartmentPhoneNumber(phone);

		return department;
	}
	

	public static Address addAdress() {
		System.out.println("Enter address id");
		int aId = scanner.nextInt();

		System.out.println("Enter the street name");
		String streetName = scanner.next();

		System.out.println("Enter the city name");
		String cityName = scanner.next();

		System.out.println("Enter the state name");
		String state = scanner.next();

		System.out.println("Enter the country name");
		String countryName = scanner.next();

		System.out.println("Enter pincode");
		int pincode = scanner.nextInt();

		Address address = new Address();

		address.setAddressId(aId);
		address.setStreet(streetName);
		address.setCity(cityName);
		address.setState(state);
		address.setCountry(countryName);
		address.setPincode(pincode);

		return address;
	}

	public static List<Employee> getEmployees(List<Employee> employee) {
		return employee;
	}

}
