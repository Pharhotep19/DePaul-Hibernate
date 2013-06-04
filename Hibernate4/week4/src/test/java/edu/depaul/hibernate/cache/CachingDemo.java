package edu.depaul.hibernate.cache;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Subqueries;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.hibernate.domain.ContractEmployee;
import edu.depaul.hibernate.domain.Employee;
import edu.depaul.hibernate.domain.FullTimeEmployee;
import edu.depaul.hibernate.domain.PartTimeEmployee;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CachingDemo {

	@Autowired
	public SessionFactory sessionFactory;

	private final String [] firstNames = {"Michael", "Erica", "Sadie", "Joyce", "Terry", "Laura", "Preston"};
	private final String [] lastNames = {"Minella", "Smith", "Jones", "Benes", "Neuberger"};
	private final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random random = new Random();

	@Test
	public void test() {
		Session session = null;

		for (int i = 0; i < 100; i++) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			DetachedCriteria subQuery = DetachedCriteria.forClass(Employee.class).setProjection(Projections.max("id"));
			Employee firstEmployee = (Employee) session
					.createCriteria(Employee.class)
					.add(Subqueries.propertyEq("id", subQuery))
					.setCacheable(true)
					.list()
					.get(0);
			System.out.println("firstEmployee's name and id are "
					+ firstEmployee.getName() + " " + firstEmployee.getId());
			session.getTransaction().commit();
			session.close();
		}
	}

	@Test
	@Ignore
	@Transactional
	@Rollback(false)
	public void populateLotsOfData() {
		Session session = sessionFactory.getCurrentSession();

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

			employee.setName(firstNames[random.nextInt(firstNames.length)] + " " + letters.charAt(random.nextInt(letters.length())) + " " +  lastNames[random.nextInt(lastNames.length)]);

			session.save(employee);
		}
	}
}
