package com.fabio.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fabio.bean.Employee;
import com.fabio.dao.EmployeeDao;

public class SpringDataDemo {

	public static void main(String[] args) {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources\\spring-configuration.xml");
			EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("EmployeeDaoImpl");

			Employee employee = new Employee("Employee123");

			employeeDao.save(employee);
			
			System.out.println("Objeto salvo = "+ employee.getEmployeeId());
			
			Employee newEmpl = employeeDao.findByPrimaryKey(employee.getEmployeeId());
			System.out.println(newEmpl);
			
			((ConfigurableApplicationContext)applicationContext).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
