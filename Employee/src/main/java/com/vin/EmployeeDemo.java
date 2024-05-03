package com.vin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				rs.getString(2);
				rs.getString(3);
				rs.getInt(4);
				rs.getDate(5);
				rs.getDouble(6);
				System.out.println(rs.getString(2));
				RequestDispatcher rd = request.getRequestDispatcher("dept.jsp");
				rd.forward(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("s", rs.getDouble(6));
				request.setAttribute("sal", rs.getDouble(6));

			} else
				response.sendRedirect("index.jsp");

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
