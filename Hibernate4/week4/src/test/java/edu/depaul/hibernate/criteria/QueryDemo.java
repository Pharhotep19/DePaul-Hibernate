package edu.depaul.hibernate.criteria;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.hibernate.domain.ContractEmployee;
import edu.depaul.hibernate.domain.Employee;
import edu.depaul.hibernate.domain.FullTimeEmployee;
import edu.depaul.hibernate.domain.PartTimeEmployee;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryDemo {

	private final String [] firstNames = {"Michael", "Erica", "Sadie", "Joyce", "Terry", "Laura", "Preston"};
	private final String [] lastNames = {"Minella", "Smith", "Jones", "Benes", "Neuberger"};
	private final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random random = new Random();

	@Autowired
	public SessionFactory sessionFactory;

	@Test
	@Transactional
	@SuppressWarnings("unchecked")
	public void testHql() {
		Session session = sessionFactory.getCurrentSession();

		List<Employee> employees = session.createQuery("from Employee").list();

		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}

	@Test
	@Transactional
	@SuppressWarnings("unchecked")
	public void testCriteria() {
		Session session = sessionFactory.getCurrentSession();

		List<Employee> employees = session.createCriteria(Employee.class).add(Restrictions.like("name", "Michael%")).list();

		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}

	@Test
	@Transactional
	@SuppressWarnings("unchecked")
	public void testSql() {
		Session session = sessionFactory.getCurrentSession();

		List<Employee> employees = session.createSQLQuery("select * from employee").addEntity(Employee.class).list();

		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}

	@Test
	@Transactional
	public void testNamedQueries() {
		Session session = sessionFactory.getCurrentSession();

		double rate = (Double) session.getNamedQuery("maxPartTimeRate").list().get(0);

		System.out.println("Max rate = " + rate);
	}

	@Test
	@Transactional
	public void populateLotsOfData() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Employee employee;
		for(int i = 0; i < 10000; i++) {
			if(i % 3 == 0) {

				employee = new ContractEmployee();

				((ContractEmployee) employee).setDailyRate(random.nextDouble());

			} else if(i % 2 == 0) {
				employee = new FullTimeEmployee();

				((FullTimeEmployee) employee).setSalary(random.nextInt());
				((FullTimeEmployee) employee).setVacation(String.valueOf(random.nextInt()));
			} else {
				employee = new PartTimeEmployee();

				((PartTimeEmployee) employee).setHourlyRate(random.nextInt());
				((PartTimeEmployee) employee).setVacation(String.valueOf(random.nextInt()));
			}

			employee.setName(firstNames[random.nextInt(firstNames.length)] + letters.charAt(random.nextInt(letters.length())) + lastNames[random.nextInt(lastNames.length)]);

			session.save(employee);
		}

		session.getTransaction().commit();
	}
}
