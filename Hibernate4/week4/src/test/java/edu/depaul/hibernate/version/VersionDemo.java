package edu.depaul.hibernate.version;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.depaul.hibernate.domain.ContractEmployee;
import edu.depaul.hibernate.domain.Employee;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class VersionDemo {

	@Autowired
	public SessionFactory sessionFactory;

	@Before
	public void setUp() {
	}

	@Test
	public void test() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee employee = new ContractEmployee();
		employee.setName("Michael Minella");

		session.save(employee);
		session.getTransaction().commit();

		System.out.println("version at the start = " + employee.getVersion());

		session.beginTransaction();
		Employee savedEmployee = (Employee) session.createQuery("from Employee").list().get(0);
		session.evict(savedEmployee);
		System.out.println("evicted version = " + savedEmployee.getVersion());
		session.getTransaction().commit();

		for(int i = 0; i < 4; i++) {
			session.beginTransaction();

			Employee emp = (Employee) session.createQuery("from Employee").list().get(0);
			emp.setName(String.valueOf(i));
			session.save(emp);

			session.getTransaction().commit();
		}

		session.beginTransaction();

		Employee updatedEmp = (Employee) session.createQuery("from Employee").list().get(0);
		System.out.println("updatedEmp's version = " + updatedEmp.getVersion());
		session.flush();
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();
	}
}
