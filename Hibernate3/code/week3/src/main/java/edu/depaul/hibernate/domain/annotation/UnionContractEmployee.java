package edu.depaul.hibernate.domain.annotation;

import javax.persistence.Entity;

@Entity
public class UnionContractEmployee extends UnionEmployee {
	private double dailyRate;

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double rate) {
		dailyRate = rate;
	}
}