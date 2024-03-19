package com.globus.tendersInfo;

import java.sql.Date;

public class TendersInfo {
	private String tendernum;

	private Date tender_Float_Date;
	private String tender_Floating_Dept;
	private String User_dept;
	private String states;
	private Date Bidding_date;
	private Date Prebid_date;
	private Date Bid_Opening_date;
	private int documentfee;
	private int EMD;
	private String Desc;
	private String BG;
	private String BOM;
	private int value;
	private String Tender_status;
	private String verticals;
	private String Assigned_to;
	private String url;
	private String remarks;
	@Override
	public String toString() {
		return "TendersInfo [tendernum=" + tendernum + ", tender_Float_Date=" + tender_Float_Date
				+ ", tender_Floating_Dept=" + tender_Floating_Dept + ", User_dept=" + User_dept + ", states=" + states
				+ ", Bidding_date=" + Bidding_date + ", Prebid_date=" + Prebid_date + ", Bid_Opening_date="
				+ Bid_Opening_date + ", documentfee=" + documentfee + ", EMD=" + EMD + ", Desc=" + Desc + ", BG=" + BG
				+ ", BOM=" + BOM + ", value=" + value + ", Tender_status=" + Tender_status + ", verticals=" + verticals
				+ ", Assigned_to=" + Assigned_to + ", url=" + url + ", remarks=" + remarks + "]";
	}
	public String getTendernum() {
		return tendernum;
	}
	public TendersInfo()
	{
		
	}
	public void setTendernum(String tendernum) {
		this.tendernum = tendernum;
	}
	public TendersInfo(String tendernum, Date tender_Float_Date, String tender_Floating_Dept, String user_dept,
			String states, Date bidding_date, Date prebid_date, Date bid_Opening_date, int documentfee, int eMD,
			String desc, String bG, String bOM, int value, String tender_status, String verticals, String assigned_to,
			String url, String remarks) {
		super();
		this.tendernum = tendernum;
		this.tender_Float_Date = tender_Float_Date;
		this.tender_Floating_Dept = tender_Floating_Dept;
		User_dept = user_dept;
		this.states = states;
		Bidding_date = bidding_date;
		Prebid_date = prebid_date;
		Bid_Opening_date = bid_Opening_date;
		this.documentfee = documentfee;
		EMD = eMD;
		Desc = desc;
		BG = bG;
		BOM = bOM;
		this.value = value;
		Tender_status = tender_status;
		this.verticals = verticals;
		Assigned_to = assigned_to;
		this.url = url;
		this.remarks = remarks;
	}
	public Date getTender_Float_Date() {
		return tender_Float_Date;
	}
	public void setTender_Float_Date(Date tender_Float_Date) {
		this.tender_Float_Date = tender_Float_Date;
	}
	public String getTender_Floating_Dept() {
		return tender_Floating_Dept;
	}
	public void setTender_Floating_Dept(String tender_Floating_Dept) {
		this.tender_Floating_Dept = tender_Floating_Dept;
	}
	public String getUser_dept() {
		return User_dept;
	}
	public void setUser_dept(String user_dept) {
		User_dept = user_dept;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public Date getBidding_date() {
		return Bidding_date;
	}
	public void setBidding_date(Date bidding_date) {
		Bidding_date = bidding_date;
	}
	public Date getPrebid_date() {
		return Prebid_date;
	}
	public void setPrebid_date(Date prebid_date) {
		Prebid_date = prebid_date;
	}
	public Date getBid_Opening_date() {
		return Bid_Opening_date;
	}
	public void setBid_Opening_date(Date bid_Opening_date) {
		Bid_Opening_date = bid_Opening_date;
	}
	public int getDocumentfee() {
		return documentfee;
	}
	public void setDocumentfee(int documentfee) {
		this.documentfee = documentfee;
	}
	public int getEMD() {
		return EMD;
	}
	public void setEMD(int eMD) {
		EMD = eMD;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getBG() {
		return BG;
	}
	public void setBG(String bG) {
		BG = bG;
	}
	public String getBOM() {
		return BOM;
	}
	public void setBOM(String bOM) {
		BOM = bOM;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getTender_status() {
		return Tender_status;
	}
	public void setTender_status(String tender_status) {
		Tender_status = tender_status;
	}
	public String getVerticals() {
		return verticals;
	}
	public void setVerticals(String verticals) {
		this.verticals = verticals;
	}
	public String getAssigned_to() {
		return Assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		Assigned_to = assigned_to;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
