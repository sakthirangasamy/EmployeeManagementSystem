package com.jspiders.emsapplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//making use of query string to delete the employee
	String sid=req.getParameter("id");
	int id=Integer.parseInt(sid);
	EMPDao.delete(id);//delete will done based on given ID
	resp.sendRedirect("ViewServlet");
}
}
