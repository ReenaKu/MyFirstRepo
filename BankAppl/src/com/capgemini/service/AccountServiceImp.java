package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.cagemini.Excepation.DublicateException;
import com.cagemini.Excepation.InsufficientIncialBalance;
import com.cagemini.Excepation.InvalidAccountException;
import com.cagemini.Excepation.InvalidAmountEx;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgeminin.reposatary.AccountReposatary;
import com.capgeminin.reposatary.AccountRepositryImp;

public class AccountServiceImp implements AccountService {
	AccountReposatary AccountR = new AccountRepositryImp();
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.Accountservice#CreaterAccount()
	 */
	@Override
	public Account CreaterAccount(int accountNo, int amount, Customer customer) throws Exception{
		if(accountNo > 0){
			if(amount >= 500 && !DublicteCheck(accountNo)){
				Account account = new Account(accountNo, amount, customer);
				//System.out.println("in create account "+ account);
				AccountR.save(account);
				//System.out.println("in create account "+ account + "Array = "+ AccountR);
				System.out.println("Account Created Succ");
				return account;
			}else{
				throw new InsufficientIncialBalance();
			}
		}
		throw new InvalidAccountException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.Accountservice#depositAmount()
	 */
	@Override
	public Account depositAmount(int AccountNo, int amount) throws InsufficientIncialBalance, InvalidAccountException{
		if(AccountNo > 0){
			if(amount >0){
				Account account = AccountR.SearchAccount(AccountNo);
				account.setAmount(account.getAmount()+amount);
				return account;
		}
		throw new InsufficientIncialBalance();
		}
		throw new InvalidAccountException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.Accountservice#withdrowAmount(int, int)
	 */
	@Override
	public Account withdrowAmount(int accountNo, int amount) throws Exception{
		Account account = AccountR.SearchAccount(accountNo);
		if(accountNo > 0 && account != null){
				synchronized (account) {
				if((account.getAmount()-amount)>=0)
				{
					account.setAmount(account.getAmount()-amount);
					return account;
				}
				
				throw new InsufficientIncialBalance();
				}
		}
		throw new InvalidAccountException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.Accountservice#fundTransfer(int, int, int)
	 */
	@Override
	public List<Account> fundTransfer(int ToAccounNo, int FromAccontNo , int amount)throws InvalidAccountException, InsufficientIncialBalance, InvalidAmountEx {
		List<Account> acc = new ArrayList<>();
		if(ToAccounNo > 0 && FromAccontNo > 0 ) {
		Account account1 = AccountR.SearchAccount(ToAccounNo);
		Account account2 = AccountR.SearchAccount(FromAccontNo);
		if(account1 != null || account2 != null) {
			synchronized (account2) {
				if(amount > 0) {
					if(account2.getAmount()-amount >= 0)
					{
						account2.setAmount(account2.getAmount()-amount);
						account1.setAmount(account1.getAmount()+amount);
						acc.add(account1);
						acc.add(account2);
						return acc;
					}
						throw new InsufficientIncialBalance();
				}
				throw new InvalidAmountEx();
			}	
		}
		throw new InvalidAccountException();
		} else {
			throw new InvalidAccountException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.Accountservice#showBalance()
	 */
	@Override
	public int showBalance(int AccountNo) throws InvalidAccountException{
		Account account = AccountR.SearchAccount(AccountNo);
		if(account != null)
			return account.getAmount();
		else
			throw new InvalidAccountException();
		
	}
	
	public boolean DublicteCheck(int AccountNo)throws DublicateException{
		Account acc = AccountR.SearchAccount(AccountNo);
		if(acc != null) {
			System.out.println("Dublicte Account");
			throw new DublicateException();
		}
		return false;
	}

}
