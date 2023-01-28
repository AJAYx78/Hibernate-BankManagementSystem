package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.AdminService;

public class DeleteAdminBy_id {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		int id=1;
		adminService.deleteAdminById(id);
	}

}
