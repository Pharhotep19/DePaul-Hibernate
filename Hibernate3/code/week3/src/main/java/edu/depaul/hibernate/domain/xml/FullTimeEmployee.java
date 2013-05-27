/* 
 * $Id: FullTimeEmployee.java mminella $
 * $Revision:  $
 * $Author: mminella $
 * $Date:  $
 * Copyright (c) 2010 Trustwave Holdings, Inc.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of Trustwave Holdings, Inc.  Use of this software is governed by
 * the terms and conditions of the license statement and limited
 * warranty furnished with the software.
 *
 * IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD TRUSTWAVE HOLDINGS INC.,
 * ITS RELATED COMPANIES AND ITS SUPPLIERS, HARMLESS FROM AND AGAINST
 * ANY CLAIMS OR LIABILITIES ARISING OUT OF OR RESULTING FROM THE USE,
 * MODIFICATION, OR DISTRIBUTION OF PROGRAMS OR FILES CREATED FROM,
 * BASED ON, AND/OR DERIVED FROM THIS SOURCE CODE FILE.
 */
package edu.depaul.hibernate.domain.xml;

/**
 * @author mminella
 *
 */
public class FullTimeEmployee extends Employee {
	
	private int vacation;
	private int salary;
	/**
	 * @return the vacation
	 */
	public int getVacation() {
		return vacation;
	}
	/**
	 * @param vacation the vacation to set
	 */
	public void setVacation(int vacation) {
		this.vacation = vacation;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
