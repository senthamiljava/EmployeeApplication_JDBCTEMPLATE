package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();

	public void save(Employee emp) {
		String sql = "insert into employee(id,name,salary) values(?,?,?)";
		Object params[] = { emp.getId(), emp.getName(), emp.getSalary() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("number of row inserted " + rows);

	}

	public Employee findById(Integer id) {
		String sql = "select id,name,salary from employee where id = ?";
		Object[] params = { id };
		Employee employee = jdbcTemplate.queryForObject(sql, params, (rs, rows) -> {
			Employee emp = convert(rs);
			return emp;
		});
		return employee;
	}

	public List<Employee> list() {
		String sql = "select id,name,salary from employee";
		List<Employee> list = jdbcTemplate.query(sql, (rs, rows) -> {
			Employee employee = convert(rs);
			return employee;
		});
		return list;
	}

	private Employee convert(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getInt("salary"));
		return employee;
	}

}
