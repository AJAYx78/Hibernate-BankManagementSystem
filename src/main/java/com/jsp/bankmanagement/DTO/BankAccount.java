package com.jsp.bankmanagement.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount")
public class BankAccount {

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CustmoreDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustmoreDto customer) {
		this.customer = customer;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private long account_no;
	private String ifsc_code;
	private double balance;
	
	@OneToOne
	private CustmoreDto customer;
}
