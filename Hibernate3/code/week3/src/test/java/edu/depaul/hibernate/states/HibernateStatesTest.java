package edu.depaul.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.depaul.hibernate.domain.xml.ContractEmployee;
import edu.depaul.hibernate.domain.xml.Employee;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateStatesTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void test() {
		demoPersistent();
		demoRemoved();
		demoDetached();
		demoReattach();
	}

	/**
	 *
	 */
	private void demoReattach() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee contractor = new ContractEmployee();
		contractor.setName("Jane Doe");
		contractor.setDailyRate(4.00);

		session.save(contractor);

		session.getTransaction().commit();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee secondContractor = (ContractEmployee) session.createQuery(
		"from ContractEmployee").list().get(0);

		session.evict(secondContractor);
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		secondContractor.setName("Thomas Jefferson");

		session.update(secondContractor);

		secondContractor.setDailyRate(100.00);

		session.getTransaction().commit();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee thirdContractor = (ContractEmployee) session.createQuery(
		"from ContractEmployee").list().get(0);

		System.out.println(thirdContractor.getName() + " makes " + thirdContractor.getDailyRate());
	}

	/**
	 *
	 */
	private void demoDetached() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee contractor = new ContractEmployee();
		contractor.setName("Jane Doe");
		contractor.setDailyRate(3.00);

		session.save(contractor);

		contractor.setName("George Washington");

		session.getTransaction().commit();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee secondContractor = (ContractEmployee) session.createQuery(
				"from ContractEmployee").list().get(0);

		System.out.println("The contractor's name = " + secondContractor.getName());

		session.evict(secondContractor);

		secondContractor.setName("John Adams");

		session.getTransaction().commit();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee thirdContractor = (ContractEmployee) session.createQuery(
				"from ContractEmployee").list().get(0);

		System.out.println("The contractor's name = " + thirdContractor.getName());
	}

	/**
	 *
	 */
	private void demoRemoved() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee contractor = new ContractEmployee();
		contractor.setName("John Smith");
		contractor.setDailyRate(2.00);

		session.save(contractor);

		session.getTransaction().commit();
		session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee toBeRemoved = (ContractEmployee) session.createQuery(
				"from ContractEmployee").list().get(0);
		System.out.println("id toBeDeleted : " + toBeRemoved.getId());
		session.delete(toBeRemoved);

		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee stillHere = (ContractEmployee) session.createQuery(
				"from ContractEmployee").list().get(0);
		System.out.println("id still here : " + stillHere.getId());

	}

	private void demoPersistent() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ContractEmployee contractor = new ContractEmployee();
		contractor.setName("Michael Minella");
		contractor.setDailyRate(1.00);

		session.save(contractor);

		session.getTransaction().commit();
		session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		Employee getEmployee = (Employee) session.get(Employee.class,
				contractor.getId());
		System.out.println(getEmployee.getClass());
		session.getTransaction().commit();
		session = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		Employee loadEmployee = (Employee) session.load(Employee.class,
				contractor.getId());

		System.out.println(loadEmployee.getClass());

		session.getTransaction().commit();
		session = null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
