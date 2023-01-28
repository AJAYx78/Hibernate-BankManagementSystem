package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.DTO.Admin;
import com.jsp.bankmanagement.Dao.AdminDao;
import com.jsp.banmanagement.Service.AdminService;

public class SaveAdmin {
	
	public static void main(String[] args) {
		
	  AdminService adminService =new AdminService();
	  
	  Admin admin=new Admin();
	  admin.setName("Arnav");
	  admin.setEmail("Arnva@gmail.com");
	  admin.setPassword("AArnav@10");
	  
	   Admin adminDto2= adminService.saveData(admin);
	   if(adminDto2!=null) {
		   System.out.println("Inserted");
	   }else {
		   System.out.println("not inserted");
	   }
	}
	

}
