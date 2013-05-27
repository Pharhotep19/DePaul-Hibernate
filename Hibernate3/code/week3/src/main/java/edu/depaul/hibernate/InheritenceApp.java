package edu.depaul.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

import edu.depaul.hibernate.domain.xml.ContractEmployee;
import edu.depaul.hibernate.domain.xml.FullTimeEmployee;
import edu.depaul.hibernate.domain.xml.PartTimeEmployee;

/**
 * I'm an Employee program!
 * 
 */
public class InheritenceApp {

	private final List<String> names = new ArrayList<String>() {
		{
			this.add("Michael Minella");
			this.add("Terry Minella");
			this.add("Rudy Neuberger");
			this.add("Russ Benes");
		}
	};

	public static void main(String[] args) {
		InheritenceApp app = new InheritenceApp();

		app.saveContractEmployees();
		app.saveFullTimeEmployees();
		app.savePartTimeEmployees();
	}

	/**
	 * 
	 */
	private void savePartTimeEmployees() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		PartTimeEmployee employee = new PartTimeEmployee();

		employee.setHourlyRate(RandomUtils.nextInt());
		employee.setVacation(RandomUtils.nextInt(365));
		int index = RandomUtils.nextInt(names.size());
		employee.setName(names.get(index));
		names.remove(index);

		System.out.println("The part timer is " + employee.getName());

		session.save(employee);

		session.getTransaction().commit();
	}

	/**
	 * 
	 */
	private void saveFullTimeEmployees() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		FullTimeEmployee employee = new FullTimeEmployee();

		employee.setSalary(RandomUtils.nextInt());
		employee.setVacation(RandomUtils.nextInt(365));
		int index = RandomUtils.nextInt(names.size());
		employee.setName(names.get(index));
		names.remove(index);

		System.out.println("The full timer is " + employee.getName());

		session.save(employee);

		session.getTransaction().commit();
	}

	/**
	 * 
	 */
	private void saveContractEmployees() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		ContractEmployee employee = new ContractEmployee();

		employee.setDailyRate(RandomUtils.nextDouble());
		int index = RandomUtils.nextInt(names.size());
		employee.setName(names.get(index));
		names.remove(index);

		System.out.println("The contractor is " + employee.getName());

		session.save(employee);

		session.getTransaction().commit();
	}
}
