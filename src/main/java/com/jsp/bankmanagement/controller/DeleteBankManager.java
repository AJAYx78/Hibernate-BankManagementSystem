package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.BankManagerService;

public class DeleteBankManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankManagerService b=new BankManagerService();
		b.deleteBankManager(3);

	}

}
