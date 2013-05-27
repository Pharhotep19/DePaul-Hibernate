package edu.depaul.hibernate.domain.annotation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class HierarchyContractEmployee extends HierarchyEmployee {
	private double dailyRate;

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double rate) {
		dailyRate = rate;
	}
}