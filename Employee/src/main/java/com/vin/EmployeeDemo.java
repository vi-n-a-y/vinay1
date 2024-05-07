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
			int rs = ps.executeUpdate();
			if (rs!=0) {
				RequestDispatcher rd = request.getRequestDispatcher("dept.jsp");
				double sal = ps.getDouble(5);
				request.setAttribute("sal",sal);
				System.out.println(sal);
				
				rd.forward(request, response);
			} else
				response.sendRedirect("index.jsp");

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

}
