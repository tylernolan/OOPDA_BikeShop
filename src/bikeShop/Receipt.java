package bikeShop;

import java.util.HashMap;
/**
 * receipt object for making receipts for customers.
 * @author Tyler
 *
 */
public class Receipt {
	private HashMap<Item, Integer> items;
	private double totalPrice;
	private Customer customer;
	/**
	 * creates a receipt object
	 * @param items the items in the customer's purchase
	 * @param customer the customer making the purchase
	 */
	public Receipt(HashMap<Item, Integer> items, Customer customer)
	{
		this.items = items;
		this.customer = customer;
	}

	public double getPrice()
	{
		return this.totalPrice;
	}
	/**
	 * 
	 * @param x a double
	 * @return the number rounded to 2 decimal places.
	 */
	public double roundDecimal(double x)
	{
		x = Math.floor(x * 100) / 100;
		return x;
	}
	/**
	 * @return a string for the receipt.
	 */
	public String generateReceipt()
	{
		return this.toString();
	}
	/**
	 * @return a string for a receipt.  
	 */
	@Override public String toString()
	{
		String retString = "";
		this.totalPrice = 0.00;
		for (Item item : items.keySet())
		{
			this.totalPrice += item.getPrice() * items.get(item);
			retString += item.toString() + "\n   Quantity: " + items.get(item) + "\n   Price: $" + roundDecimal(item.getPrice() * items.get(item))+"\n";
		}
		retString += "Total: $" + roundDecimal(this.totalPrice) + "\n";
		retString += "\n______________\n";
		retString += "Thank you for shopping with us, " + this.customer + "\n";
		return retString;
	}
}
