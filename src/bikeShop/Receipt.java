package bikeShop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
/**
 * receipt object for making receipts for customers.
 * @author Tyler
 *
 */
public class Receipt implements Serializable{
	private static int recieptNumber = 0;
	private static final long serialVersionUID = -1411947390071214055L;
	private HashMap<Item, Integer> items = new HashMap<>();
	private double totalPrice;
	private Customer customer;
	private HashSet<Rental> rentItems = new HashSet<>();
	private HashSet<Rental> itemsReturned = new HashSet<>();
	/**
	 * creates a receipt object
	 * @param items the items in the customer's purchase
	 * @param customer the customer making the purchase
	 */
	public Receipt(HashMap<Item, Integer> items, Customer customer)
	{
		recieptNumber++;
		this.items = items;
		this.customer = customer;
	}
	public Receipt(Customer customer)
	{
		recieptNumber++;
		this.customer = customer;
	}
	public void returnItem(Rental rental)
	{
		this.itemsReturned.add(rental);
	}
	public void addSaleItem(Item item)
	{
		if (items.containsKey(item))
		{
			items.put(item, items.get(item)+1);
		}
		else
		{
			items.put(item, 1);
		}
	}
	public void addRentalItem(Rental item)
	{
		this.rentItems.add(item);
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
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(String.valueOf(recieptNumber)+customer.getName()+".txt"))){
			
			writer.write(this.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		double totalDeposit = 0;
		if (rentItems.size() > 0)
			retString += "Rentals: \n";
			for (Rental i : rentItems)
			{
				retString += i.toString() + "   Deposit Due: $" + i.getItem().getRentalDeposit() + "\n   Return Date: " + i.getDueDate().toString() + "\n";
				totalDeposit += i.getItem().getRentalDeposit();
			}
		double rentalCosts = 0;
		double returnedDeposits = 0;
		if (itemsReturned.size() > 0)
		{
			retString += "Returned Items: \n";
			for (Rental rental : itemsReturned)
			{
				if (rental.isOverdue())
				{
					retString += "Overdue: ";
				}
				retString += rental.toString() +" "+ String.valueOf(rental.getAmountOwed())+"\n";
				retString += String.valueOf(rental.getAmountOwed()) + "\n";
				returnedDeposits += rental.getItem().getRentalDeposit();
			}
		}
		retString += "Total Purchases: $" + roundDecimal(this.totalPrice) + "\n";
		retString += "Total Rentals Due: $" + roundDecimal(rentalCosts)+"\n";
		retString += "Total Deposits Returned $" + roundDecimal(returnedDeposits)+"\n";
		retString += "Deposit Due: $" + roundDecimal(totalDeposit);
		retString += "\n______________\n";
		retString += "Thank you for shopping with us, " + this.customer + "\n";
		retString += new Date().toString();
		return retString;
	}
}
