package com.yashraj.yashrajhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashraj.yashrajhibernate.model.Employee;
import com.yashraj.yashrajhibernate.service.EmployeeDetailService;

@RestController
@RequestMapping("/Employee")
public class EmployeeDetailController {
	
	@Autowired
	EmployeeDetailService empService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		List<Employee> empList = empService.getAllEmployees();
		return empList;
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee emp) {
		empService.createEmployee(emp);
		return("Created Successfully");
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeDetail(@PathVariable int id) {
		return empService.getEmployeeDetail(id);
	}
	
	@PutMapping("{id}")
	public void updateEmployee(@PathVariable int id) {
		empService.updateEmployee(id);
	}

	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
	}
	
	@GetMapping("/getName/{id}")
	public String getNameDeptName(@PathVariable int id) {
		return empService.getNameAndDeptNameWithId(id);
	}
	
	@GetMapping("/getNameWithApi/{id}")
	public String getNewNameWithApiAddress(@PathVariable int id) throws Exception {
		return empService.getNewNameWithApi(id);
	}


}
