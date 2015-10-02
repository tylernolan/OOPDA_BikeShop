package bikeShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer implements Serializable{

	private static final long serialVersionUID = -8470427709741950885L;
	private String name;
	private HashMap<Item, Rental> rentedItems;
	private double accountBalance;
	private ArrayList<Item> purchaseHistory;
	
	public Customer(String name) {
		this.name = name;
		this.rentedItems = new HashMap<Item, Rental>();
		this.accountBalance = 0;
	}
	public String getName() {
		return name;
	}
	public double returnItem(Item item)
	{
		Rental rental = rentedItems.get(item);
		double amountDue = rental.getAmountOwed();
		this.accountBalance -= item.getRentalDeposit();
		return amountDue;
	}
	public void purchaseItem(Item item)
	{
		purchaseHistory.add(item);
	}
	public ArrayList<Item> getPurchaseHistory()
	{
		return this.purchaseHistory;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<Item, Rental> getRentedItems() {
		return rentedItems;
	}
	public void rentItem(Item item, Rental rental)
	{
		this.accountBalance += item.getRentalDeposit(); //the deposit goes into account balance as a positive number.
		rentedItems.put(item, rental);
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override public String toString()
	{
		return this.name;
	}
}
