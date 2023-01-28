package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.CustomerService;

public class DepositeAmount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CustomerService customerService=new CustomerService();
         customerService.depositAmount(2, 3, 2000);
	}

}
