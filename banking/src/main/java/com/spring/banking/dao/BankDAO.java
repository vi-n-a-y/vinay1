package com.spring.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spring.banking.dto.Account;
import com.spring.banking.dto.Transaction;
import com.spring.banking.dto.User;

public class BankDAO {

	public User checkCredintials(String userName, String userPass) {
		User resUser = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from User where uname='" + userName + "' and password='" + userPass + "'");

			while (rs.next()) {

				resUser.setUserId(rs.getInt("id"));
				resUser.setUname(rs.getString("uname"));
				resUser.setPassword(rs.getString("password"));
				resUser.setEmail(rs.getString("email"));
				resUser.setPhno(rs.getString("phno"));
				resUser.setAddress(rs.getString("address"));
				resUser.setFullName(rs.getString("fullName"));

			}
			if (resUser.getUserId() == 0) {
				resUser = null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resUser;
	}

	public int registerDetails(User details) {
		String Insert_user_info = "INSERT INTO user" + "(uname,password,fullName,email,phno,address)values" + "('"
				+ details.getUname() + "','" + details.getPassword() + "','" + details.getFullName() + "','"
				+ details.getEmail() + "','" + details.getPhno() + "','" + details.getAddress() + "')";

		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

			PreparedStatement ps = con.prepareStatement(Insert_user_info);

			System.out.println("the output is :" + ps);
			result = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("THE RESULT IS :" + result);

		return result;
	}

	public int setAccDetails(Account acc) {
		String Insert_data = "INSERT INTO account"
				+ "(accountNumber,bankName,ifscCode,acctType,currBalance,userId) values" + "('" + acc.getAccountNumber()
				+ "','" + acc.getBankName() + "','" + acc.getIfscCode() + "','" + acc.getAcctType() + "','"
				+ acc.getCurrBalance() + "','" + acc.getUserId() + "')";

		int data = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			PreparedStatement ps = con.prepareStatement(Insert_data);
			System.out.println("the output is :" + ps);
			data = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}
	public List<Account> getAccDetails(int id) {

		List<Account> accDetList = new ArrayList<Account>();

		String getAcc = "select * from account where userId=" + id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getAcc);

			while (rs.next()) {

				Account accDetails = new Account();

				accDetails.setId(rs.getInt("id"));
				accDetails.setAccountNumber(rs.getString("accountNumber"));
				accDetails.setBankName(rs.getString("bankName"));
				accDetails.setIfscCode(rs.getString("ifscCode"));
				accDetails.setAcctType(rs.getString("acctType"));
				accDetails.setCurrBalance(rs.getDouble("currBalance"));
				accDetails.setUserId(rs.getInt("userId"));
				accDetList.add(accDetails);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return accDetList;
	}

	public int setTransactionDetails(Transaction trxns) {
		String send_money_db = "insert into trxn(fromAcc,toAcc,description,amountSend,balance,userId)values" + "('"
				+ trxns.getFromAcc() + "','" + trxns.getToAcc() + "','" + trxns.getDescription() + "','"
				+ trxns.getAmountSend() + "','" + trxns.getBalance() + "','" + trxns.getUserId() + "')";
		;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			PreparedStatement ps = con.prepareStatement(send_money_db);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(result);
		return result;
	}

	public List<Transaction> getStatement(String acc) {
		List<Transaction> trnDto = new ArrayList<Transaction>();
		String miniStatement = "select * from trxn where fromAcc=" + acc;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(miniStatement);

			while (rs.next()) {
				Transaction accDetails = new Transaction();
				accDetails.setUserId(rs.getInt("userId"));
				accDetails.setTrnDate(rs.getDate("trnDate"));
				accDetails.setTrnId(rs.getInt("trnId"));
				accDetails.setFromAcc(rs.getString("fromAcc"));
				accDetails.setToAcc(rs.getString("toAcc"));
				accDetails.setDescription(rs.getString("description"));
				accDetails.setBalance(rs.getDouble("balance"));
				accDetails.setAmountSend(rs.getDouble("amountSend"));
				trnDto.add(accDetails);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trnDto;
	}

}
