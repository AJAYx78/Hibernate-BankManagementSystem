package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.DTO.BankManager;
import com.jsp.banmanagement.Service.BankManagerService;

public class updateBM {
	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
        
         
        //update Bankmanger by name
		bankManagerService.updateBMName(6, "Vishwa");
		
		//upadte bankmanger email
	 bankManagerService.updateBMEmail(6, "vish@30gmail.com");
		
		//update bankmager password
		bankManagerService.updateBMpassword(6, "vish@wa");
	}
	
      
}
