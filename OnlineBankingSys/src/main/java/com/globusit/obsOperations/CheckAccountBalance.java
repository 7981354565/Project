package com.globusit.obsOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.globusit.obsInfo.OnlineBankingSystem;
@WebServlet("/balance")
public class CheckAccountBalance extends GenericServlet {
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
	bankingSystem.setAccountNumber(req.getParameter("AccountNumber"));
	String url ="jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection connection =  DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement("select balance from obsystem where Account_Number=?");
		preparedStatement.setString(1, bankingSystem.getAccountNumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		PrintWriter printWriter = res.getWriter();
		int balance = 0;
		if(resultSet.next())
		{
			balance = resultSet.getInt("balance");
			printWriter.print(balance);
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("InvalidDetails.html");
			dispatcher.forward(req, res);
		}
//		System.out.println(balance)	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
