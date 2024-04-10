package com.yashraj.yashrajhibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.yashraj.yashrajhibernate.dao.EmployeeDAO;
import com.yashraj.yashrajhibernate.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Employee getEmployeeDetail(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Employee.class, id);
	}

	@Override
	public void createEmployee(@PathVariable Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(emp);
	}

	@Override
	public void updateEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		currentSession.update(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		currentSession.delete(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("From Employee", Employee.class);
		List<Employee> empList = query.getResultList();
		return empList;
	}
	
	
	@Override 
	public String getNameWithId(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		String myQuery = "SELECT e.empName FROM Employee e WHERE e.empId = :employeeId";
		Query<String> query = currentSession.createQuery(myQuery, String.class);
		query.setParameter("employeeId", id);
		return query.uniqueResult();
	}
	 
	
	@Override
	public String getDeptNameWithId(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
        Query<String> query = currentSession.createQuery(
            "SELECT e.depName FROM Employee e WHERE e.empId = :employeeId", String.class
        );
        query.setParameter("employeeId", id);
        return query.uniqueResult();
	}

	@Override
	public int updateName(String name, int id) {
		Session currentSession = entityManager.unwrap(Session.class);
	    String myQuery = "UPDATE Employee e SET e.empName = :empName WHERE e.empId = :employeeId";
	    Query query = currentSession.createQuery(myQuery);
	    query.setParameter("empName", name);
	    query.setParameter("employeeId", id);
	    int rowsAffected = query.executeUpdate();
        return rowsAffected;
	}
	
}
