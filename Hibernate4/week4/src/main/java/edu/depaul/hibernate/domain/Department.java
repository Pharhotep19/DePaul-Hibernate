package edu.depaul.hibernate.domain;

import java.util.HashSet;
import java.util.Set;
import edu.depaul.hibernate.domain.Employee;

public class Department {
	private long id;
	private int version;
	private String name;
	private String number;
	private Set<Employee> employees = new HashSet<Employee>();
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long newId) {
		id = newId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> newEmployees) {
		employees = newEmployees;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}