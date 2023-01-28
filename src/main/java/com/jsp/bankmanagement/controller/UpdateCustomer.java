package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.CustomerService;

public class UpdateCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CustomerService customerService=new CustomerService();
       customerService.updateCustomerName(1, "Sachin");
       customerService.updateCustomerGmail(1, "vkaafu@gmail.com");
       customerService.updateCustmorContact(3, 789357221);
	}

}
