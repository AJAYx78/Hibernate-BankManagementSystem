package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.Dao.CustomerDao;

public class GetAll_BankAccount {
	public static void main(String[] args) {
	 CustomerDao customerDao=new CustomerDao();
	 customerDao.getAllBankAccount();
	}

}
