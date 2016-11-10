package com.fabio.dao;

import java.sql.SQLException;

import com.fabio.bean.Employee;

public interface EmployeeDao {
	void save(Employee employee) throws SQLException;
	Employee findByPrimaryKey(long id) throws SQLException;
}
