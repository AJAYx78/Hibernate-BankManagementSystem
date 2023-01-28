package com.jsp.banmanagement.Service;

import java.util.List;

import com.jsp.bankmanagement.DTO.BankAccount;
import com.jsp.bankmanagement.DTO.CustmoreDto;
import com.jsp.bankmanagement.DTO.Statement;
import com.jsp.bankmanagement.Dao.CustomerDao;

public class CustomerService {


	CustomerDao customerDao=new CustomerDao();
	public CustmoreDto saveCustomer(CustmoreDto customer) {
		return customerDao.saveCustomer(customer);
	}

	public CustmoreDto deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
  
	public CustmoreDto updateCustomerName(int id,String Name) {
		return customerDao.updateCustomerName(id, Name);
	}
	
	public CustmoreDto updateCustomerGmail(int id,String Gmail) {
		return customerDao.updateCustomerGmail(id, Gmail);
	}
		
	public CustmoreDto updateCustmorContact(int id,long cont_no) {
		return customerDao.updateCustmorContact(id, cont_no);
	}
	
	public CustmoreDto getCustomerInfo(int id) {
		return customerDao.getCustomerInfo(id);
	}
 
	public List<CustmoreDto>  getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	public BankAccount deleteBankAccount(int id) {
		return customerDao.deleteBankAccount(id);
	}
	
	public BankAccount debitAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.debitAmount(customerId, bankAccountId, amount);
	}
	

	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		return customerDao.saveBankAccount(bankAccount, customerId);
	}
	
	public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.depositeAmount(customerId, bankAccountId, amount);
	}

	public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		return customerDao.transferAmount(customerId, creditorId, depositorId, amount);
	}
	
	public List<Statement> bankAccountStatement(int bankAccountId) {
		return customerDao.bankAccountStatement(bankAccountId);
	}
}
