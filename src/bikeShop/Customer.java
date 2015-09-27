package bikeShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
	private long getDateDifference(Date startDate, Date endDate)
	{
		return TimeUnit.DAYS.convert(startDate.getTime()-endDate.getTime(), TimeUnit.MILLISECONDS);
	}
	public double returnItem(Item item)
	{
		Date rentedDate = rentedItems.get(item);
		long timeSinceRented = getDateDifference(rentedDate, new Date());
		double amountDue = timeSinceRented * item.getDailyRentalFee();
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
	public HashMap<Item, Date> getRentedItems() {
		return rentedItems;
	}
	public void rentItem(Item item)
	{
		this.accountBalance += item.getRentalDeposit(); //the deposit goes into account balance as a positive number.
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
