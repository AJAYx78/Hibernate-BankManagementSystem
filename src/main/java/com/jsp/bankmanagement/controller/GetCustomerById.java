package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.CustomerService;

public class GetCustomerById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CustomerService customerService=new CustomerService();
       customerService.getCustomerInfo(4);
       
	}

}
