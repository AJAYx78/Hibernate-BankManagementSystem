package com.jsp.bankmanagement.controller;

import com.jsp.banmanagement.Service.AdminService;

public class GetAllAdmin {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		adminService.getAllAdmin();
	}

}
