package com.jspiders.emsapplication;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EMPDao 
{
		
		//create method for establish the connection between JAVA to RDMS
	    public static Connection getConnection()
	    {
	    	Connection con=null;
	    	try
	    	{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	String dburl="jdbc:mysql://localhost:3306/user?user=root&password=root";
	    	con=DriverManager.getConnection(dburl);
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    	return con;
	    }
	    public static int insert(EMPBean e)
	    {
	    	 int count=0;
	    	try {
	    	Connection con=EMPDao.getConnection();
	    	String query="insert into user(name,password,email,country) values(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			//setting the values for placeholder
			
			psmt.setString(1, e.getName());
			psmt.setString(2, e.getPassword());
			psmt.setString(3, e.getEmail());
			psmt.setString(4, e.getCountry());
			
			count= psmt.executeUpdate();
			con.close();
			} 
	    	
	    	catch (Exception e1) {
				
				e1.printStackTrace();
	    	}
	    	return count;
	    }
	    
	    //create method for update data into user table
	    
	    public static int update(EMPBean e)
	    {   
	    	int count=0;
	    	try {
	    		Connection con=EMPDao.getConnection();
	    		String query="update user set name=?,password=?,email=?,country=? where id=?";
	    		PreparedStatement psmt=con.prepareStatement(query);
	    		//set values for placeholders
	    		psmt.setString(1, e.getName());
				psmt.setString(2, e.getPassword());
				psmt.setString(3, e.getEmail());
				psmt.setString(4, e.getCountry());
				psmt.setInt(5,e.getId() );
				
				count=psmt.executeUpdate();
	    		con.close();
	    	}
	    	catch(Exception e2)
	    	{
	    		e2.printStackTrace();
	    	}
	    	return count;
	    }
	    //create method for delete date into user table
	    public static int delete(int id)
	    {
	    	int count=0;
	    	try
	    	{
	    	Connection con=EMPDao.getConnection();
	    	String query="delete from user where id=?";
	    	PreparedStatement psmt=con.prepareStatement(query);
	    	
	    	psmt.setInt(1, id);
	    	count=psmt.executeUpdate();
	    	con.close();
	    	}
	    	catch(Exception e3)
	    	{
	    		e3.printStackTrace();
	    	}
	    	return count;
	    }
	    
	    public static EMPBean getEmployeeById(int id)
	    {
	    	EMPBean e=new EMPBean();
	    	try
	    	{
	    		Connection con =EMPDao.getConnection();
	    		String query="select * from user where id=?";
	    		PreparedStatement psmt=con.prepareStatement(query);
	    		
	    		psmt.setInt(1, id);
	    		
	    		ResultSet rs =psmt.executeQuery();
	    		if(rs.next())
	    		{
	    			e.setId(rs.getInt(1));
	    			e.setName(rs.getNString(2));
	    			e.setPassword(rs.getString(3));
	    			e.setEmail(rs.getString(4));
	    			e.setCountry(rs.getString(5));
	    		}	
	    	}
	    	catch(Exception e1)
	    	{
	    		e1.printStackTrace();
	    	}
	    	return e;
	    }
	    //create  method to read all the employees
	    
	    public static List<EMPBean> getAllEmployees()
	    {
	    	List<EMPBean> list=new ArrayList<EMPBean>();
	    	try
	    	{
	    		Connection con=EMPDao.getConnection();
	    		String query="select * from user";
	    		PreparedStatement psmt=con.prepareStatement(query);
	    		ResultSet rs=psmt.executeQuery();
	    	    while(rs.next())
	    	    {
	    	    	EMPBean emp=new EMPBean();
	    	    	emp.setId(rs.getInt(1));
	    	    	emp.setName(rs.getString(2));
	    	    	emp.setPassword(rs.getString(3));
	    	    	emp.setEmail(rs.getString(4));
	    	    	emp.setCountry(rs.getString(5));
	    	    	list.add(emp);
	    	    }
	    	    con.close();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return list;
	    }
}


























