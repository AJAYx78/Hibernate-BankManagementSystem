package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.DTO.CustmoreDto;
import com.jsp.banmanagement.Service.CustomerService;

public class SaveCustomer {
 public static void main(String[] args) {
	 
				 CustmoreDto customer=new CustmoreDto();
				
				//If anyone try to approved directly then also it will saved as unapproved automatically.
				customer.setStatus("Approved");
				
				//Enter the customer name
				customer.setName("Poonam Bhosle ");
				
				//Enter the customer gmail
				customer.setGmail("pio@gmail.com");
				
				//Enter the customer contact number
				customer.setCno(887912342);
				
				//Enter the aadhar card number
				customer.setAddharCardNo(18568905211l);

				CustomerService customerService=new CustomerService();
				customerService.saveCustomer(customer);
			}
}

