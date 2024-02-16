package com.vin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpDao {
	
	
	public EmpDto getEmpDetails(int id) {
		EmpDto dto =new EmpDto();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Employee where empId="+id);
			if(rs.next()) {
			dto.setId(rs.getInt(1));
			dto.setEmpName(rs.getString(2));
			dto.setDoj(rs.getString(3));
			dto.setSalary(rs.getInt(4));
			}
			if(dto.getId()==0) {
				dto=null;
				
			}
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	return dto;
	}
	
	
	
	public int setEmpDetails(EmpDto dto) {
		
		int result=0;
		String st="insert into employee(empName,doj,basicSlry) values (?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps= con.prepareStatement(st);
			ps.setString(1,dto.getEmpName());
			ps.setString(2,dto.getDoj());
			ps.setInt(3,dto.getSalary());
			result=ps.executeUpdate();	
		}catch(Exception ex) {
			ex.printStackTrace();
			}	
		return result;
	}
	
	
	
	

}
