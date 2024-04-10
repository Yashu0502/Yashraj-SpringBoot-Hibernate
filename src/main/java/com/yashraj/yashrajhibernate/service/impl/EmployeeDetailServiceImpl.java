package com.yashraj.yashrajhibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yashraj.yashrajhibernate.dao.EmployeeDAO;
import com.yashraj.yashrajhibernate.handleobject.ValueExtracterFromJSON;
import com.yashraj.yashrajhibernate.model.Employee;
import com.yashraj.yashrajhibernate.service.EmployeeDetailService;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {

	@Autowired
	EmployeeDAO empDao;
	
	@Transactional
	@Override
	public Employee getEmployeeDetail(int id) {
		return empDao.getEmployeeDetail(id);
	}

	@Transactional
	@Override
	public void createEmployee(Employee emp) {
		empDao.createEmployee(emp);
	}

	@Transactional
	@Override
	public void updateEmployee(int id) {
		empDao.updateEmployee(id);
	}

	@Transactional
	@Override
	public void deleteEmployee(int id) {
		empDao.deleteEmployee(id);
	}

	@Transactional
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = empDao.getAllEmployees();
		return empList;
	}
	
	@Transactional
	@Override
	public String getNameAndDeptNameWithId(int id) {
		String name = empDao.getNameWithId(id);
		String deptName = empDao.getDeptNameWithId(id);
		return("Employee Name : " + name + " Department Name : " + deptName);
	}

	@Transactional
	@Override
	public String getNewNameWithApi(int id) throws Exception {
		String name = empDao.getNameWithId(id);
		String url = "https://api.ipify.org/?format=json";
		String ip = ValueExtracterFromJSON.valueExracter(url);
		name = name.concat(ip);
		int rows = empDao.updateName(name, id);
		System.out.println(rows);
		return(name + " " + ip);
	}
	
}
