

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Calculations")
public class Calculations extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Calculations() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 double a=Double.parseDouble(request.getParameter("num1"));
	 double b=Double.parseDouble(request.getParameter("num2"));
	double result=0;
	 String oper=request.getParameter("sel");
	  switch(oper) {
      case "+":
          result = a + b;
          break;
      case "-":
          result = a - b;
          break;
      case "*":
          result = a * b;
          break;
      case "/":
         
              result = a / b;
	  }  
	  request.setAttribute("result", result);
	 RequestDispatcher rd = request.getRequestDispatcher("operation.jsp");
	 rd.forward(request, response);
	 
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
