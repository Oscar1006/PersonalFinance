package model;

import java.util.Calendar;

public class Expense {

	private int amount;
	private String description;
	private Calendar date;
	
	public Expense(int amount, String description, Calendar date) {	
		this.amount = amount;
		this.description = description;
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public Calendar getDate() {
		return date;
	}
}
