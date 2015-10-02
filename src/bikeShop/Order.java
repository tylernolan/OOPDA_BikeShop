package bikeShop;

import java.util.HashMap;

public class Order {
	private HashMap<Item, Integer> itemsToOrder = new HashMap<>();
	
	public Order()
	{
		
	}
	public Order(HashMap<Item, Integer> itemsToOrder)
	{
		this.itemsToOrder = itemsToOrder;
	}
	public void addItemToOrder(Item item, int quantity)
	{
		for (Item i : itemsToOrder.keySet())
		{
			if (i.toString().equals(item.toString()))
			{
				Integer thing = itemsToOrder.get(i);
				thing+=quantity;
				return;
			}
		}
		itemsToOrder.put(item, quantity);
	}
	@Override public String toString()
	{
		String retString = "";
		for (Item i : itemsToOrder.keySet())
		{
			retString +="Item: "+ i.toString() + "\nQuantity: " + itemsToOrder.get(i) + "\n";
		}
		return retString;
	}
}
