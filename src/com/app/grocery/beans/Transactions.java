package com.app.grocery.beans;

import java.util.Date;

public class Transactions {
	
	int transactionID;
	Date transactionTime;
	String customerMobileNumber;
	String employeeID;
	Invoices invoiceDetail;
	Double billAmount;
	Double taxAmount;
	Double discountedAmount;
	boolean isCardPayment;
	String counterID;
	
	public String getCounterID() {
		return counterID;
	}

	public void setCounterID(String counterID) {
		this.counterID = counterID;
	}

	public Transactions(int transactionID, Date transactionTime,
			String customerMobileNumber, String employeeID,
			Invoices invoiceDetail, Double billAmount, Double taxAmount,
			Double discountedAmount, boolean isCardPayment,
			String counterID) {
		super();
		this.transactionID = transactionID;
		this.transactionTime = transactionTime;
		this.customerMobileNumber = customerMobileNumber;
		this.employeeID = employeeID;
		this.invoiceDetail = invoiceDetail;
		this.billAmount = billAmount;
		this.taxAmount = taxAmount;
		this.discountedAmount = discountedAmount;
		this.isCardPayment = isCardPayment;
		this.counterID = counterID;
	}

	public Transactions(int transactionID, Date transactionTime,
			String customerMobileNumber, String employeeID,
			Invoices invoiceDetail, Double billAmount, boolean isCardPayment,
			String counterID) {
		this(transactionID, transactionTime,
				customerMobileNumber, employeeID,
				invoiceDetail, billAmount, null,
				invoiceDetail.getDiscount(), isCardPayment,
				counterID);
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public Invoices getInvoiceDetail() {
		return invoiceDetail;
	}

	public void setInvoiceDetail(Invoices invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getDiscountedAmount() {
		return discountedAmount;
	}

	public void setDiscountedAmount(Double discountedAmount) {
		this.discountedAmount = discountedAmount;
	}

	public boolean isCardPayment() {
		return isCardPayment;
	}

	public void setCardPayment(boolean isCardPayment) {
		this.isCardPayment = isCardPayment;
	}

	@Override
	public String toString() {
		return "Transactions [transactionID=" + transactionID
				+ ", transactionTime=" + transactionTime
				+ ", customerMobileNumber=" + customerMobileNumber
				+ ", employeeID=" + employeeID + ", invoiceDetail="
				+ invoiceDetail + ", billAmount=" + billAmount + ", taxAmount="
				+ taxAmount + ", discountedAmount=" + discountedAmount
				+ ", isCardPayment=" + isCardPayment + " " +
				", counterNumber=" + counterID +"]";
	}
	
}