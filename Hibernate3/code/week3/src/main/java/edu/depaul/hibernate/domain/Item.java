package edu.depaul.hibernate.domain;

import edu.depaul.hibernate.domain.Order;
import java.util.Set;
import java.util.HashSet;

public class Item {
	
	private long id;
	private String name;
	private String number;
	private double price;
	private Set<Order> orders = new HashSet<Order>();
	
	public void setId(long newId) {
		id = newId;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setNumber(String newNumber) {
		number = newNumber;
	}
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	public void setOrders(Set<Order> newOrders) {
		orders = newOrders;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public double getPrice() {
		return price;
	}
	public Set<Order> getOrders() {
		return orders;
	}
}