package edu.depaul.hibernate.domain;

import java.util.Set;
import java.util.HashSet;

public class Order {
	
	private long id;
	private String customerName;
	private Set<Item> items = new HashSet<Item>();
	
	public long getId() {
		return id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setId(long newId) {
		id = newId;
	}
	public void setCustomerName(String name) {
		customerName = name;
	}
	public void setItems(Set<Item> newItems) {
		items = newItems;
	}
}