package com.jsp.banmanagement.Service;


import java.util.List;

import com.jsp.bankmanagement.DTO.BankManager;
import com.jsp.bankmanagement.DTO.CustmoreDto;
import com.jsp.bankmanagement.Dao.BankManagerDao;

public class BankManagerService {
	BankManagerDao bankManagerDao=new BankManagerDao();
	public BankManager saveAllBankManager(BankManager bankManager) {
		
		return bankManagerDao.saveAllBankManager(bankManager);
	}
	public BankManager updateBMName(int id,String Name) {
       return bankManagerDao.updateBMName(id, Name);
	}
	
	public BankManager updateBMEmail(int id,String Email) {
		return bankManagerDao.updateBMEmail(id, Email);
	}
	
	public BankManager updateBMpassword(int id,String password) {
		return bankManagerDao.updateBMpassword(id, password);
	}
	
	public BankManager deleteBankManager(int id) {
		BankManagerDao bankManagerDao=new BankManagerDao();
		return bankManagerDao.deleteBankManager(id);
	}
	
	public void getById(int id) {
		bankManagerDao.getById(id);
		
	}
	public List<BankManager> getAll(){
		return bankManagerDao.getAll();
		
	}
	public List<CustmoreDto> approvedCustomers(int BankmanagerId){
		return bankManagerDao.approvedCustomers(BankmanagerId);
	}
	public CustmoreDto approveCustomer(int customerId,int BankmanagerId) {
		return bankManagerDao.approveCustomer(customerId, BankmanagerId);
	}
}
