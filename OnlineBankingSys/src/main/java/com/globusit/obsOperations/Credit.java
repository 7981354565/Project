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
@WebServlet("/Credit")
public class Credit extends GenericServlet {
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter printWriter = res.getWriter();
	OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
//	System.out.println(Login.accountNumb());
	if(Login.accountNumb()==req.getParameter("accountnumber"))
	{
		printWriter.print("invalid details...9999");
		
	}
	else
	{
		bankingSystem.setAccountNumber(req.getParameter("accountnumber"));
	}
//	System.out.println(req.getParameter("accountnumber"));
	String creditAmount = req.getParameter("creditamount");
	bankingSystem.setCredit(Integer.parseInt(creditAmount));
	String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedStatement = connection.prepareStatement("select * from obsystem where Account_Number =?");
		preparedStatement.setString(1, bankingSystem.getAccountNumber());
		String accountNumber =  bankingSystem.getAccountNumber();
		ResultSet resultSet = preparedStatement.executeQuery();
		int amount =0;
		while(resultSet.next())
		{
			amount = resultSet.getInt("balance");	
		}
//		System.out.println(amount);
		PreparedStatement preparedStatement2 = connection.prepareStatement("update obsystem set credit =? , balance = ? where Account_Number=? ");
		preparedStatement2.setInt(1, bankingSystem.getCredit());
		preparedStatement2.setInt(2, bankingSystem.getCredit()+amount);
		preparedStatement2.setString(3, bankingSystem.getAccountNumber());
		int number2 = preparedStatement2.executeUpdate();
		if(number2!=0)
		{
			printWriter.write("<center><h1> Amount Credited Successfull !!! </h1></center>");
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
}
