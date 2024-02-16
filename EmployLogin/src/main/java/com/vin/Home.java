package com.vin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Home() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("empid"));
		EmpDao dao= new EmpDao();
		EmpDto dto = new EmpDto();
		dto=dao.getEmpDetails(id);
		if(dto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("empname");
		String doj=request.getParameter("empdoj");
		int salary=Integer.parseInt(request.getParameter("empslry"));
		
		EmpDto dto = new EmpDto();
		dto.setEmpName(name);
		dto.setDoj(doj);
		dto.setSalary(salary);
		EmpDao dao= new EmpDao();
		dao.setEmpDetails(dto);
		if(dto!=null) {
			response.sendRedirect("signin.jsp");
		}else {
			response.sendRedirect("register.jsp");
		}
		}
	

}
