package com.globus.tendersOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.globus.tendersInfo.TendersInfo;
@WebServlet("/url")
public class InsertingTenders extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TendersInfo info = new TendersInfo();
		info.setTendernum(req.getParameter("Tender_Num"));
		String tender_Float_Datetemp = req.getParameter("Tender_Float_Date");
		info.setTender_Float_Date(Date.valueOf(tender_Float_Datetemp));
       info.setTender_Floating_Dept(req.getParameter("Tender_Floating_Dept")); 
		info.setUser_dept(req.getParameter("User_dept"));
		info.setStates(req.getParameter("states")) ;
		String Bidding_datetemp = req.getParameter("Bidding_date");
	   info.setBidding_date( Date.valueOf(Bidding_datetemp));
		String Prebid_datetemp = req.getParameter("Prebid_date");
		info.setPrebid_date( Date.valueOf(Prebid_datetemp));
		String Bid_Opening_datetemp = req.getParameter("Bid_Opening_date");
		info.setBid_Opening_date( Date.valueOf(Bid_Opening_datetemp));
		String temp1 = req.getParameter("Document fee");
		info.setDocumentfee(Integer.parseInt(temp1));
		String temp2 = req.getParameter("EMD");
		info.setEMD(Integer.parseInt(temp2));
		info.setDesc(req.getParameter("Desc"));
		info.setBG(req.getParameter("BG"));
		info.setBOM(req.getParameter("BOM"));
		String temp3 = req.getParameter("value");
		info.setValue(Integer.parseInt(temp3));
		info.setTender_status(req.getParameter("Tender_status"));
		info.setVerticals(req.getParameter("verticals"));
		info.setAssigned_to( req.getParameter("Assigned_to"));
		info.setUrl(req.getParameter("url"));
		info.setRemarks(req.getParameter("remarks"));
		
		String url = "jdbc:mysql://localhost:3307/globusit?user=root&password=12345";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement("insert into tenders values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, info.getTendernum());
			preparedStatement.setDate(2, info.getTender_Float_Date());
			preparedStatement.setString(3, info.getTender_Floating_Dept());
			preparedStatement.setString(4, info.getUser_dept());
			preparedStatement.setString(5, info.getStates());
			preparedStatement.setDate(6, info.getBidding_date());
			preparedStatement.setDate(7, info.getPrebid_date());
			preparedStatement.setDate(8, info.getBid_Opening_date());
			preparedStatement.setInt(9, info.getDocumentfee());
			preparedStatement.setInt(10, info.getEMD());
			preparedStatement.setString(11, info.getDesc());
			preparedStatement.setString(12, info.getBG());
			preparedStatement.setString(13, info.getBOM());
			preparedStatement.setInt(14, info.getValue());
			preparedStatement.setString(15, info.getTender_status());
			preparedStatement.setString(16, info.getVerticals());
			preparedStatement.setString(17, info.getAssigned_to());
			preparedStatement.setString(18, info.getUrl());
			preparedStatement.setString(19, info.getRemarks());
			int number = preparedStatement.executeUpdate();
			PrintWriter printWriter = res.getWriter();
			if(number!=0)
			{
				printWriter.print("<h1>"+number+" record has been inserted successfully in to the tenders table </h1>");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
