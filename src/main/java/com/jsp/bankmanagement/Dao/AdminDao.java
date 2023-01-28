package com.jsp.bankmanagement.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagement.DTO.Admin;
import com.jsp.bankmanagement.DTO.BankManager;


public class AdminDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ajay");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    
	public Admin saveData(Admin adminDto) {
		entityTransaction.begin();
		entityManager.persist(adminDto);
		entityTransaction.commit();
	  
		return adminDto;
	}
	
	public Admin updateAdminName(int id,String Name) {
		Admin ad=entityManager.find(Admin.class,id);
		ad.setName(Name);
		if(ad!=null) {
			entityTransaction.begin();
			entityManager.merge(ad);
			entityTransaction.commit();
			
		}
		return ad;
	}
	
	//update admin email
	public Admin updateAdminEmail(int id,String email) {
		Admin ad =entityManager.find(Admin.class,id);
	
		
			ad.setEmail(email);
			
	if(ad!=null) {
			entityTransaction.begin();
		entityManager.merge(ad);
		entityTransaction.commit();
	
	}
		return ad;
	}
	
	//update addmin password
	public Admin updatePassword(int id,String Password) {
		Admin ad=entityManager.find(Admin.class, id);
		ad.setPassword(Password);
		if(ad!=null) {
			entityTransaction.begin();
		entityManager.merge(ad);
		entityTransaction.commit();
	
	}
		return ad;
		
	}
	public Admin getAdminById(int id) {
		Admin dt=entityManager.find(Admin.class,id);
		if(dt!=null) {
			System.out.println(dt.getId());
			System.out.println(dt.getName());
			System.out.println(dt.getEmail());
			System.out.println(dt.getPassword());
		}else {
			System.out.println("not found!");
		}
		return dt;
	}
	

	
	public void deleteAdminById(int id) {
		Admin dt=entityManager.find(Admin.class,id);
		if(dt!=null) {
		  entityTransaction.begin();
		  entityManager.remove(dt);
		  entityTransaction.commit();
		  System.out.println("Admin deleted Sucssefully");
		}else {
			System.out.println("Admin not exist");
		}

		}
	
	public List<Admin> getAllAdmin() {
		
		   String sql="select c from Admin c";
		   Query query=entityManager.createQuery(sql);
			
			List<Admin>pr=query.getResultList();
			for(Admin adminDto:pr) {
				System.out.println("=================");
				System.out.println(adminDto.getId());
				System.out.println(adminDto.getName());
				System.out.println(adminDto.getEmail());
				System.out.println(adminDto.getPassword());
			}
			return pr;
	}
	
	//approve all Manger
	public List<BankManager> approveBankManager(int AdminId){
		String sql="Select c from BankManager c";
		Query query=entityManager.createQuery(sql);
		List<BankManager> managers=query.getResultList();
		
		Admin a=entityManager.find(Admin.class, AdminId);
		if(a!=null) {
			for(BankManager m:managers) {
				if(m.getStatus().equals("Unapproved")) {
					m.setStatus("Approved");
					m.setAdmin(a);
					entityTransaction.begin();
					entityManager.merge(m);
					entityTransaction.commit();
					
					System.out.println("Approved Sucessfully");
				}
			}
			}else {
				System.out.println("Not Approve");
			}
			return managers;
		}
	
	
	//Aprove particular Manager
	
	public BankManager approvedBankmanager(int bankMangerId,int AdminId) {
		 BankManager b=entityManager.find(BankManager.class,bankMangerId );
		 Admin a=entityManager.find(Admin.class, AdminId);
		 
		 if(a!=null) {
			 if(b.getStatus().equals("Unapproved")) {
				 b.setStatus("approved");
				 b.setAdmin(a);
				 entityTransaction.begin();
				 entityManager.merge(b);
				 entityTransaction.commit();
				 System.out.println("Approve sucssesfully ");
				 
			 }else {
				 System.out.println("Bankmanager alreddy approved");
			 }
		 }else {
			 System.out.println("Admin not exist");
		 }
		 return b;
		
	}
		
}
