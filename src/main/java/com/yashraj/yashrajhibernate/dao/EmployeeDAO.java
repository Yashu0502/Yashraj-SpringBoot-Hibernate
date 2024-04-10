package com.yashraj.yashrajhibernate.dao;

import java.util.List;

import com.yashraj.yashrajhibernate.model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeDetail(int id);
	void createEmployee(Employee emp);
	void updateEmployee(int id);
	void deleteEmployee(int id);
	List<Employee> getAllEmployees();
	String getNameWithId(int id);
	String getDeptNameWithId(int id);
	int updateName(String name, int id);
}
