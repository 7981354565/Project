package com.globus.tendersOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/TendersDetails")
public class DisplayTenders extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter writer=res.getWriter();
		
		res.setContentType("text/html");
		String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
		
		try {
			// Register mysql driver with servlet class
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pst = con.prepareStatement("select * from tenders");
			writer.print("<table width=100% border=1>");
			writer.print("<caption>Tenders List:</caption>");
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			int totalcol=rsmd.getColumnCount();
			writer.print("<tr>");
			for(int i=1;i<=totalcol;i++)
			{
				writer.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			writer.print("<tr>");
			while(rs.next())
			{
				writer.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getDate(6)+"</td><td>"+rs.getDate(7)+"</td><td>"+rs.getDate(8)+"</td><td>"+
			rs.getInt(9)+"</td><td>"+rs.getInt(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td>"+rs.getInt(14)+"</td><td>"+rs.getString(15)+"</td><td>"+rs.getString(16)+"</td><td>"+
			rs.getString(17)+"</td><td>"+rs.getString(18)+"</td><td>"+rs.getString(19)+"</td></tr>");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
