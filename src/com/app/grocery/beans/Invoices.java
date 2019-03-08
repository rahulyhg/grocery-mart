package com.app.grocery.beans;

import java.util.Date;
import java.util.List;

public class Invoices {
		
	int invoiceID;
	String customerName;
	Date invoiceDate;
	List<String> items; //name,quantity,total
	Double cartAmount;
	Double discount;
	Double payAmount;
	String attendedBy;
	String counterID;
	
	public Invoices(int invoiceID, String customerName, Date invoiceDate,
			List<String> items, Double cartAmount, Double discount,
			Double payAmount, String attendedBy, String counterID) {
		super();
		this.invoiceID = invoiceID;
		this.customerName = customerName;
		this.invoiceDate = invoiceDate;
		this.items = items;
		this.cartAmount = cartAmount;
		this.discount = discount;
		this.payAmount = payAmount;
		this.attendedBy = attendedBy;
		this.counterID = counterID;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Double getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	
	public String getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(String attendedBy) {
		this.attendedBy = attendedBy;
	}

	public String getCounterID() {
		return counterID;
	}

	public void setCounterID(String counterID) {
		this.counterID = counterID;
	}

	@Override
	public String toString() {
		return "\n**********\n Invoice \n**********\n"
				+ " invoiceID=" + invoiceID + "\n customerName="
				+ customerName + "\n invoiceDate=" + invoiceDate + "\n items="
				+ items + "\n cartAmount=" + cartAmount + "\n discount="
				+ discount + "\n payAmount=" + payAmount + "\n attendedBy="
				+ attendedBy + "\n counterID=" + counterID+"\n*****************\n";
	}

}
