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
package edu.depaul.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mminella
 *
 */
public class FullTimeEmployee extends CompanyEmployee {
	private double salary;
	
	private Set<Dependent> dependents = new HashSet<Dependent>();

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the dependents
	 */
	public Set<Dependent> getDependents() {
		return dependents;
	}

	/**
	 * @param dependents the dependents to set
	 */
	public void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}

}
