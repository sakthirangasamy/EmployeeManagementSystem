package com.jspiders.emsapplication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/insert")
public class InsertServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//making use of query string to get the data from employee.html
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		
		//set the query string values by making use of EMPBean class
		
		EMPBean emp=new EMPBean();
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		int count= EMPDao.insert(emp);
		//check weather data is inserted or not
		
		if(count>0)
		{
			out.print("<h2>Employee Record Inserted Successful...!!</h2>");
			req.getRequestDispatcher("employee.html").include(req, resp);
		}
		else
		{
			out.print("<h2>Unable to Insert Employee Data</h2>");
		}
	 out.close();
	}	
}
