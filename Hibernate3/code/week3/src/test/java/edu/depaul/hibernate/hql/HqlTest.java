package edu.depaul.hibernate.hql;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.hibernate.domain.annotation.HierarchyContractEmployee;
import edu.depaul.hibernate.domain.annotation.HierarchyEmployee;
import edu.depaul.hibernate.domain.annotation.HierarchyFullTimeEmployee;
import edu.depaul.hibernate.domain.annotation.HierarchyPartTimeEmployee;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HqlTest {

	@Autowired
	private SessionFactory sessionFactory;

	private final String [] firstNames = {"Michael", "Erica", "Sadie", "Joyce", "Terry", "Laura", "Preston"};
	private final String [] lastNames = {"Minella", "Smith", "Jones", "Benes", "Neuberger"};
	private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random randomGenerator = new Random();

	@Test
	@Ignore
	@Transactional
	@Rollback(false)
	public void populateData() {
		Session session = sessionFactory.getCurrentSession();

		HierarchyEmployee employee;
		for(int i = 0; i < 10000; i++) {
			if(i % 3 == 0) {

				employee = new HierarchyContractEmployee();

				((HierarchyContractEmployee) employee).setDailyRate(randomGenerator.nextDouble());

			} else if(i % 2 == 0) {
				employee = new HierarchyFullTimeEmployee();

				((HierarchyFullTimeEmployee) employee).setSalary(randomGenerator.nextInt());
				((HierarchyFullTimeEmployee) employee).setVacation(randomGenerator.nextInt());
			} else {
				employee = new HierarchyPartTimeEmployee();

				((HierarchyPartTimeEmployee) employee).setHourlyRate(randomGenerator.nextInt());
				((HierarchyPartTimeEmployee) employee).setVacation(randomGenerator.nextInt());
			}

			employee.setName(firstNames[randomGenerator.nextInt(firstNames.length)] + " " + letters.charAt(randomGenerator.nextInt(letters.length())) + " " + lastNames[randomGenerator.nextInt(lastNames.length)]);

			System.err.println("name - " + employee.getName());
			session.save(employee);
		}
	}

	@Test
	@Transactional
	@SuppressWarnings("unchecked")
	public void queryData() {
		Session session = sessionFactory.getCurrentSession();

		List<HierarchyEmployee> employees = session.createQuery("from HierarchyContractEmployee").list();

		for (HierarchyEmployee hierarchyEmployee : employees) {
			System.err.println(hierarchyEmployee.getName());
		}
	}
}
