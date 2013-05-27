package edu.depaul.hibernate;

// import edu.depaul.hibernate.domain.Employee;
// import edu.depaul.hibernate.domain.ContractEmployee;


/**
 * I'm a people program!
 *
 */
public class HibernateStates {
//
//	public static void main(String[] args) {
//		HibernateStates app = new HibernateStates();
////		app.demoPersistent();
////		app.demoRemoved();
////		app.demoDetached();
//		 app.demoReattach();
//	}
//
//	/**
//	 *
//	 */
//	private void demoReattach() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee contractor = new ContractEmployee();
//		contractor.setName("Jane Doe");
//		contractor.setDailyRate(4.00);
//
//		session.save(contractor);
//
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee secondContractor = (ContractEmployee) session.createQuery(
//		"from ContractEmployee").list().get(0);
//
//		session.evict(secondContractor);
//		session.close();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		secondContractor.setName("Thomas Jefferson");
//
//		session.update(secondContractor);
//
//		secondContractor.setDailyRate(100.00);
//
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee thirdContractor = (ContractEmployee) session.createQuery(
//		"from ContractEmployee").list().get(0);
//
//		System.out.println(thirdContractor.getName() + " makes " + thirdContractor.getDailyRate());
//	}
//
//	/**
//	 *
//	 */
//	private void demoDetached() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee contractor = new ContractEmployee();
//		contractor.setName("Jane Doe");
//		contractor.setDailyRate(3.00);
//
//		session.save(contractor);
//
//		contractor.setName("George Washington");
//
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee secondContractor = (ContractEmployee) session.createQuery(
//				"from ContractEmployee").list().get(0);
//
//		System.out.println("The contractor's name = " + secondContractor.getName());
//
//		session.evict(secondContractor);
//
//		secondContractor.setName("John Adams");
//
//		session.getTransaction().commit();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee thirdContractor = (ContractEmployee) session.createQuery(
//				"from ContractEmployee").list().get(0);
//
//		System.out.println("The contractor's name = " + thirdContractor.getName());
//	}
//
//	/**
//	 *
//	 */
//	private void demoRemoved() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee contractor = new ContractEmployee();
//		contractor.setName("John Smith");
//		contractor.setDailyRate(2.00);
//
//		session.save(contractor);
//
//		session.getTransaction().commit();
//		session = null;
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee toBeRemoved = (ContractEmployee) session.createQuery(
//				"from ContractEmployee").list().get(0);
//		System.out.println("id toBeDeleted : " + toBeRemoved.getId());
//		session.delete(toBeRemoved);
//
//		session.close();
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee stillHere = (ContractEmployee) session.createQuery(
//				"from ContractEmployee").list().get(0);
//		System.out.println("id still here : " + stillHere.getId());
//
//	}
//
//	private void demoPersistent() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		ContractEmployee contractor = new ContractEmployee();
//		contractor.setName("Michael Minella");
//		contractor.setDailyRate(1.00);
//
//		session.save(contractor);
//
//		session.getTransaction().commit();
//		session = null;
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		Employee getEmployee = (Employee) session.get(Employee.class,
//				contractor.getId());
//		System.out.println(getEmployee.getClass());
//		session.getTransaction().commit();
//		session = null;
//
//		session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		Employee loadEmployee = (Employee) session.load(Employee.class,
//				contractor.getId());
//
//		System.out.println(loadEmployee.getClass());
//
//		session.getTransaction().commit();
//		session = null;
//	}
}
