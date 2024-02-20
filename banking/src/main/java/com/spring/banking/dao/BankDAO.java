package com.spring.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.Statement;

import com.spring.banking.dto.User;

public class BankDAO {
	
	public User checkCredintials(String userName,String userPass) {
		User resUser = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from User where uname='"+userName+"' and password='"+userPass+"'");
			
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
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return resUser;
	}
	
	public int registerDetails(User details){
		String Insert_user_info="INSERT INTO user"+
				"(uname,password,fullName,email,phno,address)values"+
				"(?,?,?,?,?,?)";
	
		int result=0;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			PreparedStatement ps=con.prepareStatement(Insert_user_info);
			
			
		
			ps.setString(1,details.getUname());
			ps.setString(2,details.getPassword());
			ps.setString(3,details.getFullName());
		    ps.setString(4,details.getEmail());
			ps.setString(5,details.getPhno());
			ps.setString(6,details.getAddress());
			ps.setInt(7, details.getUserId());
			System.out.println("the output is :"+ps);
			result=ps.executeUpdate();
			
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("THE RESULT IS :"+result);
		
		return result;
	}
	
	
	
	

}
