package com.capgemini.view;

import java.util.Scanner;

import com.cagemini.Excepation.InsufficientIncialBalance;
import com.cagemini.Excepation.InvalidAccountException;
import com.capgemini.model.Customer;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImp;

public class ClientView {

	public static void main(String[] args) throws Exception {
		Customer cum = new Customer();
		AccountService AccountService = new AccountServiceImp();
		int AccountNoConsant = 100;
//		System.out.println("1: Create Account");
//		System.out.println("2: Diposit Amount");
//		System.out.println("3: Withdrow Amount");
//		System.out.println("4: Show Blance");
//		System.out.println("5: Fund Transfer");
//		Scanner user_input = new Scanner( System.in );
//		int userinput = user_input.nextInt();
//		
//		switch (userinput) {
//        case 1: System.out.println("Enter Customer first name");
//        		cum.setFirstName(user_input.next());
//        		System.out.println("Enter Customer last name");
//        		cum.setLastName(user_input.next());
//        		System.out.println("Enter Customer Address");
//        		cum.setAddress(user_input.next());
//        		AccountNoConsant = (int)AccountNoConsant + 2;
//        		System.out.println("Enter Amount");
//        		AccountService.CreaterAccount(AccountNoConsant, user_input.nextInt(),cum);
//                break;
//                
//        case 2: System.out.println("Enter Account No");
//				int accountNo = user_input.nextInt();
//				System.out.println("Enter Amount");
//				int amount = user_input.nextInt();
//				AccountService.depositAmount(accountNo, amount);
//				break;
//				
//        case 3: System.out.println("Enter Account No");
//				int accountNo1 = user_input.nextInt();
//				System.out.println("Enter Amount");
//				int amount1 = user_input.nextInt();
//				AccountService.withdrowAmount(accountNo1, amount1);
//				break;
//				
//        case 4: System.out.println("Enter Account No");
//				int accountNo2 = user_input.nextInt();
//				AccountService.showBalance(accountNo2);
//				break;
//				
//        case 5: System.out.println("Enter Account No To");
//				int accountNo3 = user_input.nextInt();
//				System.out.println("Enter Account No From");
//				int accountNo4 = user_input.nextInt();
//				System.out.println("Enter Amount");
//				int amount3 = user_input.nextInt();
//				AccountService.fundTransfer(accountNo3, accountNo4, amount3);
//				break;
		AccountService.CreaterAccount(100, 2000, cum);
		AccountService.CreaterAccount(200, 2000, cum);
		//System.out.println(AccountService.depositAmount(100, 1000));
		//System.out.println(AccountService.showBalance(100));
		//System.out.println(AccountService.withdrowAmount(100, 1000));
		//System.out.println(AccountService.showBalance(100));
		
		//System.out.println(AccountService.withdrowAmount(100, 4000));
		
		System.out.println(AccountService.fundTransfer(100, 200, 200));
	}
//	}

}
