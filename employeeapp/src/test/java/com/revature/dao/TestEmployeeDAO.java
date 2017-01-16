package com.revature.dao;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		try {
			Employee employee = new Employee();
			employee.setId(6);
			employee.setName("naresh");
			employee.setSalary(30000);
			EmployeeDAO employeeDao = new EmployeeDAO();
			// employeedao.addEmployee(employee);
			List<Employee> list = employeeDao.list();
			for (Employee emp : list) {
				System.out.println(emp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
