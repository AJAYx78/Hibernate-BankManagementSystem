package com.jsp.bankmanagement.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagement.DTO.BankAccount;
import com.jsp.bankmanagement.DTO.CustmoreDto;
import com.jsp.bankmanagement.DTO.Statement;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ajay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	Statement statement=new Statement();

	// save customer
	public CustmoreDto saveCustomer(CustmoreDto customer) {
		String sql = "Select c from CustmoreDto c";
		Query query=entityManager.createQuery(sql);
		List<CustmoreDto> customers=query.getResultList();
		for(CustmoreDto c: customers) {
			if(c.getAddharCardNo()==customer.getAddharCardNo()) {
				System.out.println("Customer already exsit");
				return null;
			}
		}
		customer.setStatus("Unapproved");
	    entityTransaction.begin();
	    entityManager.merge(customer);
	    entityTransaction.commit();
	    System.out.println("customer saved successfully");
	    return customer;
	}
   
	//delete customer
	public CustmoreDto deleteCustomer(int id) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, id);
		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			System.out.println("Customer deleted successfully");
		} else {
			System.out.println("Customer not exist");
		}
		return c;
		}
	
	//upaate cusstomer
	
	public CustmoreDto updateCustomerName(int id,String Name) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, id);
		c.setName(Name);
		if(c!=null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}
	public CustmoreDto updateCustomerGmail(int id,String Gmail) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, id);
		c.setGmail(Gmail);
		if(c!=null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
		
	}
	
	//update customer contact
	public CustmoreDto updateCustmorContact(int id,long cont_no) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, id);
		c.setCno(cont_no);
		if(c!=null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}
	
	//get Indiviual customer details
	
	public CustmoreDto getCustomerInfo(int id) {
		CustmoreDto c=entityManager.find(CustmoreDto.class, id);
		if (c != null) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getGmail());
			System.out.println(c.getCno());
			System.out.println(c.getStatus());
		} else {
			System.out.println("Customer not exist");
		}
		return c;
	}
	
	// get all customers details
		public List<CustmoreDto>  getAllCustomer() {
			String sql = "Select c from CustmoreDto c";
			Query query = entityManager.createQuery(sql);
			List<CustmoreDto> customers = query.getResultList();

			for (CustmoreDto c : customers) {
				System.out.println("====================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getGmail());
				System.out.println(c.getCno());
				System.out.println(c.getStatus());
			}
			return customers;
		}
		
		//Save BankAccount
		public BankAccount saveBankAccount(BankAccount bankAccount ,int customerId) {
			CustmoreDto b=entityManager.find(CustmoreDto.class, customerId);
			bankAccount.setCustomer(b);
			
			//for unique account
			bankAccount.setAccount_no(9001011+customerId);
			
			String sql="Select c from BankAccount c";
			Query query=entityManager.createQuery(sql);
			
			List<BankAccount> bankAcc=query.getResultList();
			for(BankAccount c:bankAcc) {
				if(c.getAccount_no()==bankAccount.getAccount_no()) {
					System.out.println("This bankAccount already exsist");
					return null;
				}
			}
			if(b.getStatus().equals("Approved")) {
				if(bankAccount.getBalance()>499) {
					entityTransaction.begin();
					entityManager.persist(bankAccount);
					entityTransaction.commit();
					System.out.println("BankAccount added Sucessfully");
					
				}else {
					System.out.println("Minimum 500 shouldd deposite to create bankAccount");
				}
			}else {
				System.out.println("Customer is not approved");
			}
			
			
			return bankAccount;
		}
		
		//delete bankAccount
		public BankAccount deleteBankAccount(int id) {
			BankAccount b=entityManager.find(BankAccount.class, id);
			if (b != null) {
				entityTransaction.begin();
				entityManager.remove(b);
				entityTransaction.commit();
				System.out.println("BankAccount deleted successfully");
			} else {
				System.out.println("BankAccount not exist");
			}
			return b;
		}
		
		//get Particular BankAccount Details
		public BankAccount getBankAccountById(int id) {
			BankAccount b=entityManager.find(BankAccount.class, id);
			if (b != null) {
				System.out.println(b.getId());
				System.out.println(b.getAccount_no());
				System.out.println(b.getIfsc_code());
				System.out.println(b.getBalance());
			} else {
				System.out.println("BankAccount not exist");
			}
			return b;
		}
		
		//get All BankAccount details
		public List<BankAccount> getAllBankAccount(){
			String sql="select c from BankAccount c";
			Query query=entityManager.createQuery(sql);
			List<BankAccount> bankA=query.getResultList();
			for(BankAccount c:bankA) {
				System.out.println("=====================");
				System.out.println(c.getId());
				System.out.println(c.getAccount_no());
				System.out.println(c.getIfsc_code());
				System.out.println(c.getBalance());
			}
			return bankA;
			}
		
		//deposit Amount
		public BankAccount depositeAmount(int customerId, int bankAccountId, double amount) {
			CustmoreDto c=entityManager.find(CustmoreDto.class, customerId);
			BankAccount b=entityManager.find(BankAccount.class, bankAccountId);;
			if(c.getStatus().equals("Approved")) {
				if(amount>0) {
					b.setBalance(b.getBalance()+amount);
					statement.setBid(bankAccountId);
					statement.setDetails("Deposite: Rs."+amount+"to your account number"+b.getAccount_no());
					
					entityTransaction.begin();
					entityManager.merge(b);
					entityManager.persist(statement);
					entityTransaction.commit();
					System.out.println("Amount deposited Sucessfully ");
				}else {
					System.out.println("Invalid");
				}
			}else {
				System.out.println("Customer is not approve");
			}
			return b;
		}
		//debiit ammount
		public BankAccount debitAmount(int customerId, int bankAccountId, double amount) {
			CustmoreDto c = entityManager.find(CustmoreDto.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (b.getCustomer().getId() == customerId) {
					if (amount < b.getBalance() && amount > 0) {
						b.setBalance(b.getBalance() - amount);
						statement.setBid(bankAccountId);
						statement.setDetails("Debited : Rs." + amount + " from your Account no:" + b.getAccount_no());

						entityTransaction.begin();
						entityManager.merge(b);
						entityManager.persist(statement);
						entityTransaction.commit();
						System.out.println("Amount debited successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}
		// transfer amount
		Statement statement1 = new Statement();
		public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
			CustmoreDto c = entityManager.find(CustmoreDto.class, customerId);
			BankAccount b1 = entityManager.find(BankAccount.class, creditorId);
			BankAccount b2 = entityManager.find(BankAccount.class, depositorId);
			if (c.getStatus().equals("Approved")) {
				if (b1.getCustomer().getId() == customerId) {
					if (amount > 0 && b1.getBalance() > amount) {
						b1.setBalance(b1.getBalance() - amount);
						statement.setBid(creditorId);
						statement.setDetails("Debited  : Rs." + amount + " from your Account no:" + b1.getAccount_no());

						b2.setBalance(b2.getBalance() + amount);
						
						statement1.setBid(depositorId);
						statement1.setDetails(" Credited: Rs." + amount + " by Account no :" + b1.getAccount_no()+" to your account no:"+b2.getAccount_no());						entityTransaction.begin();
						entityManager.merge(b1);
						entityManager.merge(b2);
						entityManager.persist(statement);
						entityManager.persist(statement1);
						entityTransaction.commit();
						System.out.println("Amount transfer successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b1;
		}

		// statement of bankAccounts
		public List<Statement> bankAccountStatement(int bankAccountId) {
			String sql = "Select s from Statement s";
			Query query = entityManager.createQuery(sql);

			List<Statement> s = query.getResultList();
			System.out.println("Statement of BankAccount Id : "+bankAccountId);
			for (Statement res : s) {
				if (bankAccountId == res.getBid()) {
					System.out.println(res.getDetails());
				}
			}
			return s;
		}
		
		}
		

