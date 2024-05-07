package com.vin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/emp")
public class EmployeeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDemo() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		int id = Integer.parseInt(request.getParameter("empId"));
		System.out.println(id);
		try {
			String str = "select * from employee where id=" + id;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rs.getInt(1);
				String name=rs.getString(2);
				Date hireDate=rs.getDate(5);
				System.out.println(hireDate);
			
				System.out.println(name);
				System.out.println(rs.getString(2));
				RequestDispatcher rd = request.getRequestDispatcher("dept.jsp");

				HttpSession session = request.getSession();
		
				request.setAttribute("name",name);
				request.setAttribute("hireDate", hireDate);
				rd.forward(request, response);
			} else
				response.sendRedirect("index.jsp");

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = 1;
		double updateSalary = Double.parseDouble(request.getParameter("updateSalary"));
		System.out.println(updateSalary);
		
		String str = "update employee set salary="+updateSalary+" where id="+id;
		
		System.out.println(str);
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			PreparedStatement ps = con.prepareStatement(str);
			int data = ps.executeUpdate();
			if (data>0) {
				 String selectQuery = "SELECT salary FROM employee WHERE id = ?";
		            try (PreparedStatement ps1 = con.prepareStatement(selectQuery)) {
		                ps1.setInt(1, id);
		                try (ResultSet rs = ps1.executeQuery()) {
		                    if (rs.next()) {
		                        double sal = rs.getDouble(1); // Assuming salary is the first column in the SELECT query
		                        request.setAttribute("sal", sal);
		                        System.out.println(sal);
		                        
		                        RequestDispatcher rd = request.getRequestDispatcher("dept.jsp");
		                        rd.forward(request, response);
		                    }
		                }
		            }
		        } else {
		            response.sendRedirect("index.jsp");
		        }

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        // Handle SQLException appropriately
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}


// create table dept(
// id int auto_increment primary key,
// dept_name varchar(50));


// create table employee(
// id int auto_increment primary key,
// emp_name varchar(50) not null,
// emp_nmbr varchar(50) not null,
// dept_id int ,
// join_date date ,
// salary double, foreign key (dept_id) references dept(id));
// select * from dept;
// insert into employee(emp_name,emp_nmbr,dept_id,salary) 
// values 
// ("krishna","14587",1,21000),
// ("Rohit","58746",2,20000),
// ("tirumala","68950",3,31000);
// select * from employee;
// use bank;
// select * from employee;

// update employee set salary=11000.0 where id=1;


