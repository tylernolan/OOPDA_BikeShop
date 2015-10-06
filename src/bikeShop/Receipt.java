package bikeShop;

import java.util.HashMap;

public class Receipt {
	private HashMap<Item, Integer> items;
	private double totalPrice;
	public Receipt(HashMap<Item, Integer> items)
	{
		this.items = items;
		this.toString();
	}
	public double getPrice()
	{
		return this.totalPrice;
	}
	public double roundDecimal(double x)
	{
		x = Math.floor(x * 100) / 100;
		return x;
	}
	public String generateReceipt()
	{
		return this.toString();
	}
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
		retString += "Thank you for shopping with us \n";
		return retString;
	}
}
