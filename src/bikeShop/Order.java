package bikeShop;

import java.util.HashMap;
/**
 * Class for a hashmap of orders
 */
public class Order {
	private HashMap<Item, Integer> itemsToOrder = new HashMap<>();
	public Order()
	{
		
	}
	public Order(HashMap<Item, Integer> itemsToOrder)
	{
		this.itemsToOrder = itemsToOrder;
	}
	/**
	 * increments the quantity of the item by the quantity specified.
	 * @param item the item you'd like to increase the quantity of
	 * @param quantity the quantity you'd like to increase by.
	 */
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
