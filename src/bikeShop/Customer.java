package bikeShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * customer object for customer data
 * @author Tyler
 *
 */
public class Customer implements Serializable{

	private static final long serialVersionUID = -8470427709741950885L;
	private String name;
	private ArrayList<Rental> rentedItems = new ArrayList<>();
	private double accountBalance;
	private ArrayList<Item> purchaseHistory = new ArrayList<>();
	/**
	 * 
	 * @param name the customer's name
	 */
	public Customer(String name) {
		this.name = name; //TODO: make NameErrorException and have the constructor throw it if the name isn't valid.
		this.rentedItems = new ArrayList<Rental>();
		this.accountBalance = 0;
	}
	public String getName() {
		return name;
	}
	/**
	 * returns the item rented by a customer
	 * @param item the item that was rented
	 * @return returns the amount due
	 */
	public double returnItem(Rental r)
	{
		Rental rental = r;
		double amountDue = rental.getAmountOwed();
		this.accountBalance -= rental.getItem().getRentalDeposit();
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
	public ArrayList<Rental> getRentedItems() {
		return rentedItems;
	}
	/**
	 * adds a rental to the customer's rentedItems field, and adds the cost of the deposit to the customer's balance. 
	 * @param item the item being rented
	 * @param rental
	 */
	public void rentItem(Item item, Rental rental)
	{
		this.accountBalance += item.getRentalDeposit(); //the deposit goes into account balance as a positive number.
		rentedItems.add(rental);
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	/**
	 * @return the customer's name.
	 */
	@Override public String toString()
	{
		return this.name;
	}
}
