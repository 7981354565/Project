package com.globus.tendersOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.globus.tendersInfo.TendersInfo;
@WebServlet("/UpdatingTenderFields")
public class UpdatingTenderFields extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TendersInfo  info = new TendersInfo();
		info.setTendernum(req.getParameter("Tender_Num"));
		info.setBidding_date(Date.valueOf(req.getParameter("Bidding_date")));
		info.setBid_Opening_date(Date.valueOf(req.getParameter("Bid_Opening_date")));
		info.setTender_status(req.getParameter("Tender_status"));
		String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement("update tenders set Bidding_Date=?,Bid_Opening_Date=?,Status=? where Tender_Num=?");
			preparedStatement.setDate(1,info.getBidding_date());
			preparedStatement.setDate(2,info.getBid_Opening_date());
			preparedStatement.setString(3, info.getTender_status());
			preparedStatement.setString(4, info.getTendernum());
			int number = preparedStatement.executeUpdate();
			PrintWriter printWriter = res.getWriter();
			if(number!=0)
			{
				printWriter.write("<h1>"+number+" record updated successfully </h1>");
			}
			else
			{
				printWriter.write("<center><h1> Invalid Details </h1></center>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("UpdatingTender.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
