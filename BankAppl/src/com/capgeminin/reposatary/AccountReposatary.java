package com.capgeminin.reposatary;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public interface AccountReposatary {

	boolean save(Account account);

	Account SearchAccount(int AccountNo);

	//boolean updateAccount(Account account);

	boolean updateAccount(Account account, Customer customer);

}