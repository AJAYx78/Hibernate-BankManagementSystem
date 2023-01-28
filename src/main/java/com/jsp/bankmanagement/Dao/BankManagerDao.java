package com.jsp.bankmanagement.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.CustomEntityDirtinessStrategy;

import com.jsp.bankmanagement.DTO.BankManager;
import com.jsp.bankmanagement.DTO.CustmoreDto;

public class BankManagerDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ajay");
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//Save Bankmanager
	public BankManager saveAllBankManager(BankManager bankManager) {
		//If anyone try to approved directly then also it will saved as unapproved automatically.
		bankManager.setStatus("Unapproved");
	  entityTransaction.begin();
	  entityManager.persist(bankManager);
	  entityTransaction.commit();
	  return bankManager;
		
	}
	
	//update bankmanager
	public BankManager updateBMName(int id,String Name) {
		BankManager b=entityManager.find(BankManager.class, id);
		 
		b.setName(Name);
	//	b.setEmail(bankManagerdto.getEmail());
	//	b.setPassword(bankManagerdto.getPassword());
		if(b!=null) {
		entityTransaction.begin();
		entityManager.merge(b);
		entityTransaction.commit();
		}
		return b;
		
	}
	public BankManager updateBMEmail(int id,String Email) {
		BankManager b=entityManager.find(BankManager.class, id);
		 
		b.setEmail(Email);
	
		if(b!=null) {
		entityTransaction.begin();
		entityManager.merge(b);
		entityTransaction.commit();
		}
		return b;
		
	}
	public BankManager updateBMpassword(int id,String password) {
		BankManager b=entityManager.find(BankManager.class, id);
		 
		b.setPassword(password);
	//	b.setEmail(bankManagerdto.getEmail());
	//	b.setPassword(bankManagerdto.getPassword());
		if(b!=null) {
		entityTransaction.begin();
		entityManager.merge(b);
		entityTransaction.commit();
		}
		return b;
		
	}

	//delete bankManager
	public BankManager deleteBankManager(int id) {
		BankManager b=entityManager.find(BankManager.class, id);
		if(b!=null) {
		entityTransaction.begin();
		entityManager.remove(b);
		entityTransaction.commit();
		System.out.println("Remove succesfully");
		}else {
			System.out.println("not exist");
		}
		return b;
	}
	
	//Get BankManager By Id
	public void getById(int id) {
		
			BankManager b=entityManager.find(BankManager.class, id);
			if(b!=null) {
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getEmail());
			}else {
				System.out.println("ID not found");
			}
			
	}
	
	//to get all Bankmanager
	public List<BankManager> getAll(){
		String sql="select c from BankManager c";
		Query query=entityManager.createQuery(sql);
		
		List<BankManager> b=query.getResultList();
		for(BankManager ab:b) {
			System.out.println("====================");
			System.out.println(ab.getId());
			System.out.println(ab.getName());
			System.out.println(ab.getEmail());
			System.out.println(ab.getPassword());
		}
		return b;
	}
	//approve all bankmanager
	
	public List<CustmoreDto> approvedCustomers(int BankmanagerId){
		String sql="Select c from CustmoreDto c";
		Query query=entityManager.createQuery(sql);
		List<CustmoreDto> custmores = query.getResultList();
        BankManager b=entityManager.find(BankManager.class, BankmanagerId);
        if(b.getStatus().equals("Approved")) {
        	for(CustmoreDto c:custmores) {
        		if(c.getStatus().equals("Unapproved")) {
        			c.setStatus("Approved");
        			c.setBankManager(b);
        			entityTransaction.begin();
        			entityManager.merge(c);
        			entityTransaction.commit();
        		}
        	}
		}else {
			System.out.println("Bankmanager is Not approved");
		}
        return custmores;
	}
	
	//approve particular customer
	
	public CustmoreDto approveCustomer(int customerId,int BankmanagerId) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, customerId);
		BankManager b=entityManager.find(BankManager.class, BankmanagerId);
		
		if(b.getStatus().equals("Approved")) {
			if(c.getStatus().equals("Unapproved")) {
				c.setStatus("Approved");
				c.setBankManager(b);
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
				System.out.println("Approved Sucssesfully");
				
			}else {
				System.out.println("Customer is already approved");
			}
		}else {
				System.out.println("BankManager is Not approved");
			}
			return c;
		}
	}
	


