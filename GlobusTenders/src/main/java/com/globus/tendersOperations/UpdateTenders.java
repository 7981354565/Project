package com.globus.tendersOperations;

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

import com.globus.tendersInfo.TendersInfo;
@WebServlet("/TenderNumber")
public class UpdateTenders extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TendersInfo tendersInfo = new  TendersInfo();

		tendersInfo.setTendernum(req.getParameter("Tender_Num"));
		System.out.println(req.getParameter("Tender_Num"));
		String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from tenders where Tender_Num=?");
			preparedStatement.setString(1, tendersInfo.getTendernum());
			ResultSet  resultSet = preparedStatement.executeQuery();
			PrintWriter writer = res.getWriter();
			if(resultSet.next())
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("UpdatingTender.html");
				dispatcher.forward(req, res);
			}
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("FetchingTender.html");
				dispatcher.include(req, res);
				writer.println(" Invalid Details ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
