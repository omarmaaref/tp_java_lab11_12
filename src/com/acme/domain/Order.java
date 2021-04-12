package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {

	private MyDate orderDate;
	private double orderAmount;
	private static double taxRate = 0.05;
	private String customer;
	private Product product;
	private int quantity;
private static Rushable rushable;
	public static Rushable getRushable(){return rushable;}
	public static void setRushable(Rushable rushable)
	{Order.rushable = rushable;}
	public boolean isPriorityOrder(){
		boolean priorityOrder = false;if( rushable != null ) {priorityOrder = rushable.isRushable(orderDate, orderAmount);}
		return priorityOrder;}

	public Order(MyDate d, double amt, String c, Product p, int q) {
		setOrderDate(d);
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	public char jobSize() {
		if (quantity <= 25)
			return 'S';
		if (quantity > 25 && quantity <= 75)
			return 'M';
		if (quantity > 75 && quantity <= 150)
			return 'L';
		return 'X';
	}

	public double computeTotal() {

		double finalAmount = orderAmount + computeTax();
		if (orderAmount > 1500)
			finalAmount = orderAmount;
		switch (jobSize()) {
			case 'S':
				return finalAmount;
			case 'M':
				return finalAmount - orderAmount * 0.01;
			case 'L':
				return finalAmount - orderAmount * 0.02;
			default:
				return finalAmount - orderAmount * 0.03;

		}
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public static double getTaxRate() {
		return taxRate;
	}


	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}
