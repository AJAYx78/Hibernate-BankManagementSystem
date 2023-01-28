package com.jsp.banmanagement.Service;

import java.util.List;

import com.jsp.bankmanagement.DTO.Admin;
import com.jsp.bankmanagement.DTO.BankManager;
import com.jsp.bankmanagement.Dao.AdminDao;

public class AdminService {
	
	public Admin saveData(Admin adminDto) {
		AdminDao adminDao=new AdminDao();
		return adminDao.saveData(adminDto);
	}
	
	public Admin updateAdminName(int id,String Name) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updateAdminName(id, Name);
		
	}
	
	public Admin updateAdminEmail(int id,String email) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updateAdminEmail(id, email);
		
	}
	
	public Admin updatePassword(int id,String Password) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updatePassword(id, Password);
	}
	public Admin getAdminById(int id) {
		AdminDao adminDao=new AdminDao();
		return adminDao.getAdminById(id);
	}
	public void deleteAdminById(int id) {
		AdminDao adminDao=new AdminDao();
		adminDao.deleteAdminById(id);
	}
	public List<Admin> getAllAdmin() {
		AdminDao adminDao=new AdminDao();
		return adminDao.getAllAdmin();
	}
	public List<BankManager> approveBankManager(int AdminId){
		AdminDao adminDao=new AdminDao();
		return adminDao.approveBankManager(AdminId);
	}
	public BankManager approvedBankmanager(int bankMangerId,int AdminId) {
		AdminDao adminDao=new AdminDao();
		return adminDao.approvedBankmanager(bankMangerId, AdminId);
	}
}
