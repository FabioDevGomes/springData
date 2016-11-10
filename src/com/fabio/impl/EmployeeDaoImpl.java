package com.fabio.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fabio.bean.Employee;
import com.fabio.dao.EmployeeDao;

@Repository("EmployeeDaoImpl")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Employee employee) throws SQLException {
		entityManager.persist(employee);
		
	}

	@Override
	public Employee findByPrimaryKey(long id) throws SQLException {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
