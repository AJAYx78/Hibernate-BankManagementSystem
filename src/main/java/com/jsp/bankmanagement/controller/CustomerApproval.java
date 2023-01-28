package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.BankManagerService;

public class CustomerApproval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BankManagerService bankManagerService=new BankManagerService();
       

		//For approved all customers
		//Enter the bankManagerId
       bankManagerService.approvedCustomers(7);
       
     //For approved particular customer
     		//Enter the customerId and bankManagerId
       bankManagerService.approveCustomer(4, 4);
       
	}

}
