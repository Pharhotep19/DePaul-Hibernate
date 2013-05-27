/* 
 * $Id: AtmService.java mminella $
 * $Revision:  $
 * $Author: mminella $
 * $Date:  $
 */
package edu.depaul.service;

import java.util.List;

import edu.depaul.hibernate.domain.Card;
import edu.depaul.hibernate.domain.Customer;
import edu.depaul.hibernate.domain.Transaction;

/**
 * @author mminella
 *
 */
public interface AtmService {

	List<Double> getBalancesByCard(Card card);
	
	List<Transaction> getLastTransactions(Card card, int qty);
	
	Customer getCustomer(Card card);
}
