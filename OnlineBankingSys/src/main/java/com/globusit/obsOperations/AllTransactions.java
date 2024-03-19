package com.globusit.obsOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.globusit.obsInfo.OnlineBankingSystem;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
@WebServlet("/AllTransc")
public class AllTransactions extends GenericServlet {
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
	PrintWriter writer=res.getWriter();
	bankingSystem.setAccountNumber(req.getParameter("AccountNumber"));
	res.setContentType("text/html");
	String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
	
	try {
		// Register mysql driver with servlet class
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement  preparedStatement = connection.prepareStatement("select credit, debit from obsystem where Account_Number=?");
		preparedStatement.setString(1,bankingSystem.getAccountNumber() );
		writer.print("<center><table width=50% border=1></center>");
		writer.print("<caption> Last Transactions : </caption>");
		ResultSet resultSet = preparedStatement.executeQuery();
		ResultSetMetaData rsmd=(ResultSetMetaData) resultSet.getMetaData();
		writer.print("<th>"+rsmd.getColumnName(1)+"</th>");
		writer.print("<th>"+rsmd.getColumnName(2)+"</th>");
		int totalcol=rsmd.getColumnCount();
		
		writer.print("<tr>");
		while(resultSet.next())
		{
			writer.print("<tr><td>"+resultSet.getInt(1)+"</td><td>"+resultSet.getInt(2));
		}	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}

