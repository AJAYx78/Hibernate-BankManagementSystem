package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.Dao.CustomerDao;

public class Get_BankAccount {
  public static void main(String[] args) {
	CustomerDao customerDao=new CustomerDao();
	customerDao.getBankAccountById(3);
}
}
