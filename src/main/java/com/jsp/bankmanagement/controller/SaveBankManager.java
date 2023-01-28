package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.DTO.BankManager;
import com.jsp.banmanagement.Service.BankManagerService;

public class SaveBankManager {

	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager=new BankManager();
		//If anyone try to approved directly then also it will saved as unapproved automatically.
		bankManager.setStatus("Approved");
		bankManager.setName("Prathmesh");
		bankManager.setEmail("makvanaprathmesh@gmail.com");
		bankManager.setPassword("makva@Prathmesh");
	BankManager	b1=bankManagerService.saveAllBankManager(bankManager);
		if(b1!=null) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not inserted");
		}
	}
}
