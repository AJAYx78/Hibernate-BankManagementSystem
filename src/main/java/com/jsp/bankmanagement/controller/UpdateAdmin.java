package com.jsp.bankmanagement.controller;

import com.jsp.bankmanagement.DTO.Admin;
import com.jsp.banmanagement.Service.AdminService;

public class UpdateAdmin {
   public static void main(String[] args) {
	
	   AdminService adminService=new AdminService();
	   int id=6;
	   //to update admin name
     adminService.updateAdminName(id, "vishal");
       
       //to update admin email
	   adminService.updateAdminEmail(id, "Vishal@gmail.com");
     //to update admin paassword
	   adminService.updatePassword(id, "vishaal@123");
   }
	
}
