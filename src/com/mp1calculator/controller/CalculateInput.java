package com.mp1calculator.controller;

import java.io.IOException;
import com.mp1calculator.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateInput
 */
@WebServlet("/calculate.action")
public class CalculateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			response.setContentType("text/html");
			CalculatorBean calculator = new CalculatorBean();
			
			calculator.setNum1(Double.parseDouble(request.getParameter("num1"))); 
			calculator.setOperation(request.getParameter("operation"));
			calculator.setNum2(Double.parseDouble(request.getParameter("num2")));  
			calculator.answerString();

			
			
			java.io.PrintWriter out = response.getWriter();
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("	<head><meta charset=\"ISO-8859-1\"><title>MP1 Calculator</title><link href=\"main.css\" rel=\"stylesheet\">\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head></head>");
			out.print("	<body><div class=\"global-container\">\r\n"
					+ "	<div class=\"card calc-form\">\r\n"
					+ "	<div class=\"card-body\">\r\n"
					+ "		<h3 class=\"card-title text-center\">MP1 Calculator</h3>\r\n"
					+ "		<div class=\"card-text\">");
			if(calculator.isDivByZero()) {
				out.print("	<p><b> Division by zero is prohibited, try again! </b></p>");
				out.print("		<form action='index.html'>");
				out.print("			<input type='submit' class=\"btn btn-primary btn-block\" value='TRY AGAIN'/>");
				out.print("		</form></div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "</div>");
				out.print("		<hr/>");
				out.print("	</body>");
				out.print("</html>");
			}else if(calculator.isOperationNull()){
				out.print("	<p><b> You Haven't Entered an Operation! </b></p>");
				out.print("		<form action='index.html'>");
				out.print("			<input type='submit' class=\"btn btn-primary btn-block\" value='TRY AGAIN'/>");
				out.print("		</form></div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "</div>");
				out.print("		<hr/>");
				out.print("	</body>");
				out.print("</html>");
			
			}else if(calculator.isInvalidOperation()){
				out.print("	<p><b> You Have Entered a Wrong Operation! </b></p>");
				out.print("		<form action='index.html'>");
				out.print("			<input type='submit' class=\"btn btn-primary btn-block\" value='TRY AGAIN'/>");
				out.print("		</form></div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "</div>");
				out.print("		<hr/>");
				out.print("	</body>");
				out.print("</html>");
			}else {
				out.print("		<p><b>The selected mathematical operation is "+ calculator.getOperation() +"</b></p>");
				out.print("		<p>" + calculator.getOperationMessage()+ "<b>"+ calculator.getNum1() +"</b> by <b>"+ calculator.getNum2() +"</b> is "+ calculator.getAnswer() +"</p>");
				out.print("		<p><b>Thank you very much for using the system.</b></p>");
				out.print("		<form action='index.html'>");
				out.print("			<input type='submit' class=\"btn btn-primary btn-block\" value='GO BACK'/>");
				out.print("		</form></div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "</div>");
				out.print("		<hr/>");
				out.print("	</body>");
				out.print("</html>");
			}
			out.close();
		}catch(NumberFormatException nfe){
			java.io.PrintWriter out = response.getWriter();
			
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("	<head><meta charset=\"ISO-8859-1\"><title>MP1 Calculator</title><link href=\"main.css\" rel=\"stylesheet\">\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head></head>");
			out.print("	<body><div class=\"global-container\">\r\n"
					+ "	<div class=\"card calc-form\">\r\n"
					+ "	<div class=\"card-body\">\r\n"
					+ "		<h3 class=\"card-title text-center\">MP1 Calculator</h3>\r\n"
					+ "		<div class=\"card-text\">");
			out.print("	<p><b> One of your number forms are empty! </b></p>");
			out.print("		<form action='index.html'>");
			out.print("			<input type='submit' class=\"btn btn-primary btn-block\" value='TRY AGAIN'/>");
			out.print("		</form></div>\r\n"
					+ "	</div>\r\n"
					+ "</div>\r\n"
					+ "</div>");
			out.print("		<hr/>");
			out.print("	</body>");
			out.print("</html>");
		}
		
	}

}
