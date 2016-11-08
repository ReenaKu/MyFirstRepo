package com.capgemini.Test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cagemini.Excepation.DublicateException;
import com.cagemini.Excepation.InsufficientIncialBalance;
import com.cagemini.Excepation.InvalidAccountException;
import com.cagemini.Excepation.InvalidAmountEx;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImp;

import static org.junit.Assert.*;

public class MyTest {
	static AccountService acccountservice;
	static Customer customer;
	static Account account;
	static Account account1;
	
	
	@BeforeClass
	public static void setup(){
		acccountservice = new AccountServiceImp();
		customer = new Customer();
		customer.setLastName("kumari");
		customer.setAddress("katraj");
		customer.setFirstName("reena");
		account =  new Account(100, 1000, customer);
		//account1 =  new Account(200, 1000, customer);
		// AccountService.CreaterAccount(200, 2000, new Customer());
		
	}
	@Test(expected = InvalidAccountException.class)
	public void NegativeAccountNoShouldThrowException()throws InvalidAccountException,Exception
	{
		acccountservice.CreaterAccount(-6, 1000, customer);
	}
	@Test
	public void WhenValidInfoPassAccountShoouldCreated() throws Exception{
		acccountservice.CreaterAccount(100, 1000, customer);
	}
	@Test(expected=DublicateException.class)
	public void DublicteAccountNoShouldThrowException() throws Exception{
		assertEquals(account,acccountservice.CreaterAccount(100, 1000, customer));
	}
	
	@Test(expected=InvalidAccountException.class)
	public void NullAccountNoShouldThrowException() throws Exception{
		acccountservice.CreaterAccount(0, 6000, customer);
	}
	
	@Test(expected=InsufficientIncialBalance.class)
	public void WhenAmountLessThenIncialAmountShouldThrowException() throws Exception{
		acccountservice.CreaterAccount(20000, 100, customer);
	}
	
	@Test
	public void WhenValidAmountPassAccountDeposited() throws InsufficientIncialBalance, InvalidAccountException{
		acccountservice.depositAmount(100, 2000);
	}
	
	@Test(expected = InvalidAccountException.class)
	public void WhenINValidAccountNoPassShoulsThrowEx() throws InsufficientIncialBalance, InvalidAccountException{
		acccountservice.depositAmount(-99, 2000);
	}
	@Test(expected = InsufficientIncialBalance.class)
	public void WhenINValidAmountPassShoulsThrowEx() throws InsufficientIncialBalance, InvalidAccountException{
		acccountservice.depositAmount(100, -2000);
	}
	@Test
	public void WhenValidInfoPassShouldWithdrowAmountSucc() throws Exception{
		acccountservice.withdrowAmount(100, 1000);
	}
	@Test(expected=InvalidAccountException.class)
	public void WhenAccountNoNegataveShoudThrowEx() throws Exception{
		acccountservice.withdrowAmount(-100, 1000);
	}
	@Test(expected=InvalidAccountException.class)
	public void WhenAccountNoInvalidShoudThrowEx() throws Exception{
		acccountservice.withdrowAmount(10000, 1000);
	}
	@Test(expected=InsufficientIncialBalance.class)
	public void WhenAmountMoreThenIncialAmount() throws Exception{
		acccountservice.withdrowAmount(100, 100000);
	}
	@Test
	public void WhenvalidInfoPass() throws Exception{
		acccountservice.CreaterAccount(200, 2000, new Customer());
		acccountservice.fundTransfer(100,200, 100);
	}
	@Test(expected=InvalidAccountException.class)
	public void WhenInvalidAccountNoShouldThrowEx() throws InvalidAccountException, InsufficientIncialBalance, InvalidAmountEx{
		acccountservice.fundTransfer(-100, -600, 200);
	}
	@Test(expected=InsufficientIncialBalance.class)
	public void WhenAmounNotMoreThenIncialAmountShouldThrowEx() throws InvalidAccountException, InsufficientIncialBalance,Exception{
		//acccountservice.CreaterAccount(200, 2000, new Customer());
		acccountservice.fundTransfer(100, 200, 20000);
	}
	@Test(expected=InvalidAmountEx.class)
	public void whenNegativeValuePassForTransfer() throws InvalidAccountException, InsufficientIncialBalance, InvalidAmountEx{
		acccountservice.fundTransfer(100, 200,-88);
	}
	
}
