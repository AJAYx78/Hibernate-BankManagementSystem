package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.AdminService;

public class Approve_BankManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     AdminService adminService=new AdminService();
     //enter AdminId to Approve all Baankmanaager
     adminService.approveBankManager(5);
     
     //Enter the bankManager id and admin id for approve particular bankManager
     adminService.approvedBankmanager(5, 3);
	}

}
