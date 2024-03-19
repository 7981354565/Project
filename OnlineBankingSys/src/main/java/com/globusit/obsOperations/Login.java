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
import com.mysql.cj.jdbc.result.ResultSetMetaData;
@WebServlet("/Login")
public class Login extends GenericServlet {
String accountNum = "";
public  static String accountNumb()
{
	String accountNum = "";
	return accountNum ;
}
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter printWriter = res.getWriter();
	OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
	accountNum = ""+req.getParameter("AccountNumber");
	bankingSystem.setAccountNumber(req.getParameter("AccountNumber"));
	bankingSystem.setUserName(req.getParameter("username"));
	bankingSystem.setPassword(req.getParameter("password"));
	String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement("select * from obsystem where Account_Number=? and User_Name=? and Password=?");
		preparedStatement.setString(1, bankingSystem.getAccountNumber());
		preparedStatement.setString(2, bankingSystem.getUserName());
		preparedStatement.setString(3, bankingSystem.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()==true)
		{
			printWriter.write("<center><h1> Login Successfully Done !!!!</h1></center>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("LoginMain.html");
			dispatcher.forward(req, res);
		}
		else
		{
			printWriter.write("<center><h1> Invalid Details </h1></center>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("InvalidDetails.html");
			dispatcher.forward(req, res);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
