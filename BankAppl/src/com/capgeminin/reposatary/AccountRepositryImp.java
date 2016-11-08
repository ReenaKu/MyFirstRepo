package com.capgeminin.reposatary;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public class AccountRepositryImp implements AccountReposatary {
	private Set<Account> accounts = new LinkedHashSet<>();
	
	/* (non-Javadoc)
	 * @see com.capgeminin.reposatary.AccountReposatary#save(com.capgemini.model.Account)
	 */
	@Override
	public boolean save(Account account){
		if(account != null) {
			accounts.add(account);
			//System.out.println("Account Array " + accounts);
			return true;
		}	
		return false;
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgeminin.reposatary.AccountReposatary#SearchAccount(int)
	 */
	@Override
	public Account SearchAccount(int AccountNo){
		Iterator<Account> it = (Iterator<Account>) accounts.iterator();
		while(it.hasNext()){
			Account account= it.next();
			if(account.getAccountNumber()== AccountNo)
				return account;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.capgeminin.reposatary.AccountReposatary#updateAccount(com.capgemini.model.Account)
	 */
	@Override
	public boolean updateAccount( Account account, Customer customer){
		Account account1= SearchAccount(account.getAccountNumber());
		if(account1 != null){
			account1.setCustomer(customer);
			account1.setAmount(account.getAmount());
		}
		return false;
		
	}

}
