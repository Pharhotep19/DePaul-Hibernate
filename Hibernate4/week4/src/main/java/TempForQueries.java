import java.util.Random;

import org.hibernate.Session;

/*
 * $Id: TempForQueries.java mminella $
 * $Revision:  $
 * $Author: mminella $
 * $Date:  $
 */

/**
 * @author mminella
 *
 */
public class TempForQueries {

	private Session session;
	private Random random;

	private void runSomeQueries() {
//
//		// Named parameter in HQL
//		Query query = session
//				.createQuery("from Employee where name like :name");
//
//		query.setString("name", "Michael%");
//
//		List<Employee> employees = query.list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Basic Criteria
//		List<Employee> employees = session.createCriteria(Employee.class)
//				.list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Basic filter
//		List<Employee> employees = session.createCriteria(Employee.class).add(
//				Restrictions.like("name", "Michael%")).list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Criteria with join filter
//		List<FullTimeEmployee> employees = session.createCriteria(
//				FullTimeEmployee.class).createCriteria("dependents").add(
//				Restrictions.like("name", "Michael%")).list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Criteria filtering with Property.forName
//		Property name = Property.forName("name");
//		List<Employee> employees = session.createCriteria(Employee.class).add(
//				name.like("Michael%", MatchMode.START)).list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Criteria filtering with Property.forName 2
//		Property name = Property.forName("name");
//		Property city = Property.forName("city");
//		List<Employee> employees = session.createCriteria(Employee.class).add(
//				name.like("Michael%", MatchMode.START)).add(city.eq("Chicago"))
//				.list();
//
//		System.out.println("We got back " + employees.size() + " employees");
//
//		// Order by
//		List<FullTimeEmployee> employees = session.createCriteria(
//				FullTimeEmployee.class).add(Restrictions.eq("city", "Chicago"))
//				.addOrder(Order.asc("name")).list();
//
//		System.out.println("******* Employees ******************************");
//		for (Employee employee : employees) {
//			System.out.println(employee.getName());
//		}
//
//		// Eager fetching
//		List<FullTimeEmployee> employees = session.createCriteria(
//				FullTimeEmployee.class).add(Restrictions.eq("city", "Chicago"))
//				.setFetchMode("dependents", FetchMode.JOIN)
//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//
//		System.out.println("******* Employees ******************************");
//		for (Employee employee : employees) {
//			System.out.println(employee.getName());
//		}
//
//		// Row Count
//		Integer count = (Integer) session
//				.createCriteria(FullTimeEmployee.class).add(
//						Restrictions.eq("city", "Chicago")).setProjection(
//						Projections.rowCount()).uniqueResult();
//
//		System.out.println("Row count = " + count);
//
//		// SQL example
//		List<Object[]> results = session.createSQLQuery(
//				"select * from employee where employee_type = 'PTE'").list();
//
//		for (Object[] object : results) {
//			for (Object object2 : object) {
//				System.out.println(object2);
//			}
//		}
//
//		// SQL example with entity
//		List<PartTimeEmployee> results = session.createSQLQuery(
//				"select * from employee where employee_type = 'PTE'")
//				.addEntity(PartTimeEmployee.class).list();
//
//		for (PartTimeEmployee employee : results) {
//			System.out.println(employee.getName());
//		}
//
//		// Named HQL query
//		Double rate = (Double) session.getNamedQuery("maxPartTimeRate")
//				.uniqueResult();
//
//		System.out.println("Max rate = " + rate);
//
//		// Named SQL query
//		Double rate = (Double) session.getNamedQuery("minPartTimeRate")
//				.uniqueResult();
//
//		System.out.println("Min rate = " + rate);
//
//		// cached query example
//		for (int i = 0; i < 100; i++) {
//			session = HibernateUtil.getSessionFactory().openSession();
//
//			Query query = session.createQuery(
//					"from Employee where name like :name").setCacheable(true);
//
//			query.setString("name", "Michael%");
//
//			List<Employee> employees = query.list();
//
//			System.out
//					.println("We got back " + employees.size() + " employees");
//
//			session.close();
//		}
//
//		// cached lookup example
//		for (int i = 0; i < 1000; i++) {
//			session = HibernateUtil.getSessionFactory().openSession();
//
//			Employee emp = null;
//
//			try {
//				emp = (Employee) session.load(Employee.class, new Long(
//						RandomUtils.nextInt(100)));
//			} catch (Throwable ignore) {
//			}
//
//			if (emp != null && emp.getId() > 0) {
//				System.out.println(emp.getId() + ":" + emp.getName());
//			}
//
//			session.close();
//		}
//
//		// Version example
//		Employee employee = (Employee) session.createCriteria(Employee.class)
//				.add(Restrictions.like("name", "Michael%")).list().get(0);
//
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		Employee quickerEmployee = (Employee) session.get(Employee.class,
//				employee.getId());
//
//		quickerEmployee.setName("Michael Jackson");
//
//		session.saveOrUpdate(quickerEmployee);
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.saveOrUpdate(employee);
//		session.getTransaction().commit();
	}
}
