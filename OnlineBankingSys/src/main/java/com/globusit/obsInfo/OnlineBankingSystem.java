package com.globusit.obsInfo;

public class OnlineBankingSystem {
private String accountNumber;
private String userName;
private String password;
private int credit;
private int debit;
private int balance;
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getCredit() {
	return credit;
}
public void setCredit(int credit) {
	this.credit = credit;
}
public int getDebit() {
	return debit;
}
public void setDebit(int debit) {
	this.debit = debit;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "OnlineBankingSystem [accountNumber=" + accountNumber + ", userName=" + userName + ", password=" + password
			+ ", credit=" + credit + ", debit=" + debit + ", balance=" + balance + "]";
}
/**
 * @param accountNumber
 * @param userName
 * @param password
 * @param credit
 * @param debit
 * @param balance
 */

/**
 * 
 */
public OnlineBankingSystem() {
}

}
