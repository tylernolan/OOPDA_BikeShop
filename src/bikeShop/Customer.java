package bikeShop;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	private static final long serialVersionUID = -8470427709741950885L;
	private String name;
	private ArrayList<Item> rentedItems;
	private double accountBalance;
	public Customer(String name) {
		super();
		this.name = name;
		this.rentedItems = new ArrayList<Item>();
		this.accountBalance = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Item> getRentedItems() {
		return rentedItems;
	}
	public void rentItem(Item item)
	{
		rentedItems.add(item);
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
