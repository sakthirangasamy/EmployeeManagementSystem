package com.jspiders.emsapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.print("<a href='employee.html'>Add New Employee</a>");
	out.print("<h2>Employee's List</h2>");
	List <EMPBean> list=EMPDao.getAllEmployees();
	
	
	
	out.print("<table border='1' width='100%'>");
	out.print("<tr>"
			+"<th>ID</th>"
			+"<th>NAME</th>"
			+"<th>PASSWORD</th>"
			+"<th>EMAIL</th>"
			+"<th>COUNTRY</th>"
			+"<th>EDIT</th>"
			+"<th>DELETE</th>"
			+"</tr>");
	for(EMPBean emp:list) {
		out.print("<tr><td>"+emp.getId()+"</td>"
				+"<td>"+emp.getName()+"</td>"
				+"<td>"+emp.getPassword()+"</td>"
				+"<td>"+emp.getEmail()+"</td>"
				+"<td>"+emp.getCountry()+"</td>"
				+"<td><a href='EditServlet?id='"+emp.getId()+">Edit</a></td>"
				+ "<td><a href='DeleteServlet?id='"+emp.getId()+">Delete</a></td>"
		     + "</tr>");
}
out.print("</table>");
out.close();
}
	
}

