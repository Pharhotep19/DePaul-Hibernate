package edu.depaul.hibernate;

// import edu.depaul.hibernate.domain.Employee;
// import edu.depaul.hibernate.domain.ContractEmployee;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.hibernate.tutorial.util.HibernateUtil;
import org.hibernate.Session;

import edu.depaul.hibernate.domain.Item;
import edu.depaul.hibernate.domain.xml.ContractEmployee;
import edu.depaul.hibernate.domain.xml.Employee;
import edu.depaul.hibernate.domain.xml.FullTimeEmployee;
import edu.depaul.hibernate.domain.xml.PartTimeEmployee;

/**
 * I'm a people program!
 * 
 */
public class HqlDemo {
	
	private final String [] firstNames = {"Michael", "Erica", "Sadie", "Joyce", "Terry", "Laura", "Preston"};
	private final String [] lastNames = {"Minella", "Smith", "Jones", "Benes", "Neuberger"};

	public static void main(String[] args) {
		HqlDemo app = new HqlDemo();
		
//		app.populateLotsOfData();
		app.querySomeData();
	}

	/**
	 * 
	 */
	private void querySomeData() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.getTransaction().commit();
	}

	/**
	 * 
	 */
	private void populateLotsOfData() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Employee employee;
		for(int i = 0; i < 10000; i++) {
			if(i % 3 == 0) {
				
				employee = new ContractEmployee();
				
				((ContractEmployee) employee).setDailyRate(RandomUtils.nextDouble());
				
			} else if(i % 2 == 0) {
				employee = new FullTimeEmployee();

				((FullTimeEmployee) employee).setSalary(RandomUtils.nextInt());
				((FullTimeEmployee) employee).setVacation(RandomUtils.nextInt());
			} else {
				employee = new PartTimeEmployee();

				((PartTimeEmployee) employee).setHourlyRate(RandomUtils.nextInt());
				((PartTimeEmployee) employee).setVacation(RandomUtils.nextInt());
			}
			
			employee.setName(firstNames[RandomUtils.nextInt(firstNames.length)] + RandomStringUtils.randomAlphabetic(1).toUpperCase() + lastNames[RandomUtils.nextInt(lastNames.length)]);
			
			session.save(employee);
		}
		
		session.getTransaction().commit();
	}

}
