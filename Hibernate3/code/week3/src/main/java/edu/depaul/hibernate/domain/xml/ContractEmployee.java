package edu.depaul.hibernate.domain.xml;

public class ContractEmployee extends Employee {
	private double dailyRate;
	
	public double getDailyRate() {
		return dailyRate;
	}
	
	public void setDailyRate(double rate) {
		dailyRate = rate;
	}
}