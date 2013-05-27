package edu.depaul.hibernate.domain.xml;

public abstract class Employee {
	private long id;
	private String name;
	
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
}