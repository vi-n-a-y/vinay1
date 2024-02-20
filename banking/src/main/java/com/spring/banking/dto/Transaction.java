package com.spring.banking.dto;

import java.sql.Date;

public class Transaction {
	
	private Date trnDate;
	private int trnId;

	private String fromAcc;
	private String toAcc;
	private String description;
	private double amountSend;
	private double balance;
	private int userId;
	
	
	public Date getTrnDate() {
		return trnDate;
	}
	public int getTrnId() {
		return trnId;
	}
	public String getFromAcc() {
		return fromAcc;
	}
	public String getToAcc() {
		return toAcc;
	}
	public String getDescription() {
		return description;
	}
	public double getAmountSend() {
		return amountSend;
	}
	public double getBalance() {
		return balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}
	public void setTrnId(int trnId) {
		this.trnId = trnId;
	}
	public void setFromAcc(String fromAcc) {
		this.fromAcc = fromAcc;
	}
	public void setToAcc(String toAcc) {
		this.toAcc = toAcc;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmountSend(double amountSend) {
		this.amountSend = amountSend;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
