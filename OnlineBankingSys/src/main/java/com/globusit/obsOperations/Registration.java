package com.globusit.obsOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.globusit.obsInfo.OnlineBankingSystem;
@WebServlet("/Register")
public class Registration extends GenericServlet{
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter printWriter = res.getWriter();
	OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
	bankingSystem.setAccountNumber(req.getParameter("AccountNumberrr"));
	bankingSystem.setUserName(req.getParameter("username"));
	bankingSystem.setPassword(req.getParameter("password"));
	String reEnterPassword = req.getParameter("ReEnterPassword");
//	System.out.println(req.getParameter("password"));
//	System.out.println(reEnterPassword);
	if(bankingSystem.getPassword().equals(reEnterPassword))
	{
		String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement("insert into obsystem(Account_Number,User_Name,Password) values(?,?,?)");
			preparedStatement.setString(1, bankingSystem.getAccountNumber());
			preparedStatement.setString(2, bankingSystem.getUserName());
			preparedStatement.setString(3, bankingSystem.getPassword());
			int number = preparedStatement.executeUpdate();
			System.out.println(number);
			if(number!=0)
			{
				printWriter.write("<center><h1> Registration Successfully Done !!!</h1></center>");
			}
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("InvalidDetails.html");
				dispatcher.forward(req, res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		RequestDispatcher dispatcher = req.getRequestDispatcher("InvalidDetails.html");
		dispatcher.forward(req, res);
	}
	
}
}
