package bikeShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Customer implements Serializable{

	private static final long serialVersionUID = -8470427709741950885L;
	private String name;
	private HashMap<Item, Date> rentedItems;
	private double accountBalance;
	private ArrayList<Item> purchaseHistory;
	
	public Customer(String name) {
		this.name = name;
		this.rentedItems = new HashMap<Item, Date>();
		this.accountBalance = 0;
	}
	public String getName() {
		return name;
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
	public HashMap<Item, Date> getRentedItems() {
		return rentedItems;
	}
	public void rentItem(Item item)
	{
		Date currentDate = new Date();
		rentedItems.put(item, currentDate);
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
