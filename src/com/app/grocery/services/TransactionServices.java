package com.app.grocery.services;

import java.util.Date;

import com.app.grocery.beans.Invoices;
import com.app.grocery.beans.Transactions;
import com.app.grocery.interfaces.TransactionInterface;
import com.app.grocery.stub.StubManager;

public class TransactionServices implements TransactionInterface {
	StubManager stubManagerConnection = StubManager.getInstance();
	
	public final static TransactionServices txnServices = new TransactionServices();

	protected TransactionServices() {
	};

	public static TransactionServices getTxnServices() {
		return txnServices;
	}

	@Override
	public void addTransaction(Transactions transaction) {
		StubManager stubManagerConnection = StubManager.getInstance();
		stubManagerConnection.getTransactionList().add(transaction);
	}

	@Override
	public void printAllTransaction() {
		System.out.println(stubManagerConnection.getTransactionList());
	}

	@Override
	public void isDiscountApplicable(boolean isEmployee, boolean isSeniorCitizen) {
	}

	@Override
	public void printStatement(Date rangeFrom, Date rangeTo) {
	}
	
	public int getInvoiceID(){
		return stubManagerConnection.getTransactionList().size() + 1;
	}

	public void saveInvoices(Invoices invoiceObject) {
		Transactions transObject = new Transactions(getInvoiceID(), new Date(), invoiceObject.getCustomerName(), invoiceObject.getAttendedBy(), invoiceObject, invoiceObject.getPayAmount(), false, invoiceObject.getCounterID());
		stubManagerConnection.getTransactionList().add(transObject);
	}

}
