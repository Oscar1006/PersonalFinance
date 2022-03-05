package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PersonalFinance {

	private ArrayList<Income> income;
	private ArrayList<Expense> expenses;

	private int balance;

	public PersonalFinance() {
		income = new ArrayList<Income>();
		expenses = new ArrayList<Expense>();
		addIncome(4000, "cuatro", new GregorianCalendar(2022, 3, 1));
		addIncome(5000, "cinco", new GregorianCalendar(2022, 3, 2));
		addExpense(2000, "hola", new GregorianCalendar(2022, 3, 5));
		addExpense(3000, "hola", new GregorianCalendar(2022, 3, 6));

	}

	public void addIncome(int amount, String description, GregorianCalendar date) {
		income.add(new Income(amount, description, date));
	}

	public void addExpense(int amount, String description, GregorianCalendar date) {
		expenses.add(new Expense(amount, description, date));
	}

	public void deleteIncome(int index) {
		income.remove(index);
	}

	public void deleteExpense(int index) {
		expenses.remove(index);
	}

	public ArrayList<Income> getIncome() {
		return income;
	}

	public ArrayList<Income> getIncome(GregorianCalendar since, GregorianCalendar until) {
		ArrayList <Income> incomeBetweenDates = new ArrayList<>();
		for (int i = 0; i < income.size(); i++) {
			boolean isAfterSince = income.get(i).getDate().compareTo(since) > 0;
			boolean isBeforeUntil = income.get(i).getDate().compareTo(until) < 0;
			if (isAfterSince && isBeforeUntil) {
				incomeBetweenDates.add(income.get(i));
			}
		}
		return incomeBetweenDates;
	}
	public ArrayList<Expense> getExpenses() {
		return expenses;
	}
	public ArrayList<Expense> getExpense(GregorianCalendar since, GregorianCalendar until) {
		ArrayList <Expense> expensesBetweenDates = new ArrayList<>();
		for (int i = 0; i < expenses.size(); i++) {
			boolean isAfterSince = expenses.get(i).getDate().compareTo(since) > 0;
			boolean isBeforeUntil = expenses.get(i).getDate().compareTo(until) < 0;
			if (isAfterSince && isBeforeUntil) {
				expensesBetweenDates.add(expenses.get(i));
			}
		}
		return expensesBetweenDates;
	}

	public int getBalance() {
		int totalIncome = 0;
		for (int i = 0; i < income.size(); i++) {
			totalIncome += income.get(i).getAmount();
		}
		int totalExpenses = 0;
		for (int i = 0; i < expenses.size(); i++) {
			totalExpenses += expenses.get(i).getAmount();
		}
		balance = totalIncome - totalExpenses;

		return balance;
	}

	public int getBalance(GregorianCalendar since, GregorianCalendar until) {
		int totalIncome = 0;
		for (int i = 0; i < income.size(); i++) {
			boolean isAfterSince = income.get(i).getDate().compareTo(since) >= 0;
			boolean isBeforeUntil = income.get(i).getDate().compareTo(until) <= 0;
			if (isAfterSince && isBeforeUntil) {
				totalIncome += income.get(i).getAmount();
			}
		}
		int totalExpenses = 0;
		for (int i = 0; i < expenses.size(); i++) {
			boolean isAfterSince = income.get(i).getDate().compareTo(since) >= 0;
			boolean isBeforeUntil = income.get(i).getDate().compareTo(until) <= 0;
			if (isAfterSince && isBeforeUntil) {
				totalExpenses += expenses.get(i).getAmount();
			}
			
		}
		balance = totalIncome - totalExpenses;

		return balance;
	}

}
