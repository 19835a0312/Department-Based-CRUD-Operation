package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A 
{
	private String path="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/palle";
	private String username="root";
	private String password="admin";

	Connection con=null;
	Statement stm=null;
	PreparedStatement ps=null;
	
	public void creating()
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			stm=con.createStatement();
			
			//Step-4:Execute query
			stm.executeUpdate("create table dept(dno int primary key auto_increment,dname varchar(100),dlocation varchar(100),dstrength int)");
			
			//step-5:close connections
			stm.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void getDeptNames()
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			stm=con.createStatement();
			
			//Step-4:Execute query
			ResultSet res=stm.executeQuery("select distinct dname from dept");
			
			//step-5:read/process data coming from ResultSet
			while(res.next()==true)
			{
				System.out.println("dname : "+res.getString("dname"));
			}
			
			//step-5:close connections
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void getDeptNameOnDno(int dno)
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			ps=con.prepareStatement("select dname from dept where dno=?");
			ps.setInt(1, dno);
			
			//Step-4:Execute query
			ResultSet res=ps.executeQuery();
			
			//step-5:read/process data coming from ResultSet
			while(res.next()==true)
			{
				System.out.println("dname : "+res.getString("dname"));
			}
			
			//step-5:close connections
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void updateDeptNameOnDno(int dno,String dname)
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			ps=con.prepareStatement("update dept set dname=? where dno=?");
			ps.setString(1, dname);
			ps.setInt(2, dno);
			
			//Step-4:Execute query
			ps.executeUpdate();
			
			//step-5:close connections
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void inserting(String dname,String dlocation,int dstrength)
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			ps=con.prepareCall("insert into dept(dname,dlocation,dstrength) values(?,?,?)");
			
			//step-4:insert input values into query
			ps.setString(1,dname);
			ps.setString(2, dlocation);
			ps.setInt(3, dstrength);
			
			
			//Step-5:Execute query
			ps.executeUpdate();
			
			
			//step-6:close connections
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void delete(int dno)
	{
		try 
		{
			//Step-1:load the Driver class
			Class.forName(path);
			
			//Step-2:Establish connection
			con=DriverManager.getConnection(url,username,password);
			
			//Step-3:create SQL statement
			ps=con.prepareStatement("delete from dept where dno=?");
			
			//step04:insert input values into query
			ps.setInt(1,dno);
			
			//Step-5:Execute query
			ps.executeUpdate();
			
			
			//step-6:close connections
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
