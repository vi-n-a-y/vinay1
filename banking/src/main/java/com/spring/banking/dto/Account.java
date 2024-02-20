package com.spring.banking.dto;

public class Account {
	
	private int id;

	private String accountNumber;
	private String ifscCode;
	private String bankName;
	private String acctType;
	private double currBalance;
	private int userId;
	
	public int getId() {
		return id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public String getAcctType() {
		return acctType;
	}
	public double getCurrBalance() {
		return currBalance;
	}
	public int getUserId() {
		return userId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public void setCurrBalance(double currBalance) {
		this.currBalance = currBalance;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
