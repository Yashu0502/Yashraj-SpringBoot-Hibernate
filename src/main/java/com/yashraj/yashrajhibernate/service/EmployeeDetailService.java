package com.yashraj.yashrajhibernate.service;

import java.util.List;

import com.yashraj.yashrajhibernate.model.Employee;

public interface EmployeeDetailService {
	
	public Employee getEmployeeDetail(int id);
	public void createEmployee(Employee emp);
	public void updateEmployee(int id);
	public void deleteEmployee(int id);
	public List<Employee> getAllEmployees();
	public String getNameAndDeptNameWithId(int id);
	public String getNewNameWithApi(int id) throws Exception;
	
}
