package com.capgemini.service;

import java.util.List;

import com.cagemini.Excepation.DublicateException;
import com.cagemini.Excepation.InsufficientIncialBalance;
import com.cagemini.Excepation.InvalidAccountException;
import com.cagemini.Excepation.InvalidAmountEx;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public interface AccountService {

	//Account CreaterAccount();

	//Account depositAmount();

	Account withdrowAmount(int accountNo, int amount)throws Exception;

	List<Account> fundTransfer(int ToAccounNo, int FromAccontNo, int amount)throws InvalidAccountException, InsufficientIncialBalance, InvalidAmountEx;

	//int showBalance();

	Account CreaterAccount(int acconuNo, int amount, Customer customer)throws Exception;

	Account depositAmount(int AccountNo, int amount)throws InsufficientIncialBalance, InvalidAccountException;

	int showBalance(int AccountNo)throws InvalidAccountException;
	public boolean DublicteCheck(int AccountNo)throws DublicateException;

}