package com.jsp.bankmanagement.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustmoreDto {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gmail;
	private long cno;
	private String status;
	private long AddharCardNo;
	
	@ManyToOne
	@JoinColumn
	
	private BankManager bankManager;
	public BankManager getBankManager() {
		return bankManager;
	}
	public void setBankManager(BankManager bankManager) {
		this.bankManager = bankManager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public long getCno() {
		return cno;
	}
	public void setCno(long cno) {
		this.cno = cno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAddharCardNo() {
		return AddharCardNo;
	}
	public void setAddharCardNo(long addharCardNo) {
		AddharCardNo = addharCardNo;
	}

}
