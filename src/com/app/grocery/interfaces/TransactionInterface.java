package com.app.grocery.interfaces;

import java.util.Date;

import com.app.grocery.beans.Transactions;

public interface TransactionInterface {

	public void addTransaction(Transactions transaction);
	public void printAllTransaction();
	public void isDiscountApplicable(boolean isEmployee, boolean isSeniorCitizen);
	public void printStatement(Date rangeFrom, Date rangeTo);
	
}
