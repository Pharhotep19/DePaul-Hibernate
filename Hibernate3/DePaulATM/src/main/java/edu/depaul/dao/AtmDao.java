/* 
 * $Id: AtmDao.java mminella $
 * $Revision:  $
 * $Author: mminella $
 * $Date:  $
 *
 */
package edu.depaul.dao;

import edu.depaul.hibernate.domain.Card;
import edu.depaul.hibernate.domain.Customer;
import edu.depaul.hibernate.domain.Transaction;

/**
 * @author mminella
 *
 */
public interface AtmDao {
	
	Customer getCustomerByCard(Card card);
	
	void saveTransaction(Transaction trans);
	
	double getCurrentBalance(String accountNumber);

}
