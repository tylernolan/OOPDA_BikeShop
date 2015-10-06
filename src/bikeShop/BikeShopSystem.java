package bikeShop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class BikeShopSystem implements Serializable{
	private static final long serialVersionUID = -7876747047024597307L;
	private ArrayList<Item> inventory;
	private HashSet<Customer> customers;
	private ArrayList<Rental> ongoingRentals;
	
	public BikeShopSystem()
	{
		this.inventory = new ArrayList<Item>();
		this.customers = new HashSet<Customer>();
		this.ongoingRentals = new ArrayList<Rental>();
	}
	public Receipt generateReceipt(HashMap<Item, Integer> items)
	{
		Receipt receipt = new Receipt(items);
		return receipt;
	}
	public Rental generateRental(Customer rentee, Item item, int rentalTerm)
	{
		Rental rental =  new Rental(rentee, item, rentalTerm, new Date());
		rentee.rentItem(item, rental);
		this.ongoingRentals.add(rental);
		return rental;
		
	}
	public Order orderBikes(HashMap<Item, Integer> thingsToOrder)
	{
		Order order = new Order(thingsToOrder);
		return order;
	}
	public HashSet<Customer> getCustomers()
	{
		return this.customers;
	}
	public ArrayList<Item> getInventory()
	{
		return this.inventory;
	}
	public void addItemToInventory(Item itemToAdd)
	{
		inventory.add(itemToAdd);
	}
	public void sellItem(Customer customer, Item item)
	{
		customer.purchaseItem(item);
		inventory.remove(item);
	}
	public boolean newCustomer(String name)
	{
		if(name.split(" ").length == 2)
		{
			customers.add(new Customer(name));
			return true;
		}
		else
		{
			return false; //must supply a first and last name.
		}
	}
	public void saveShopState()
	{
		FileOutputStream file;
		ObjectOutputStream out;
		try
		{
			file = new FileOutputStream("state.ser");
			out = new ObjectOutputStream(file);
			out.writeObject(this);
			file.close();
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static BikeShopSystem loadShopState()
	{
		FileInputStream file;
		ObjectInputStream in;
		BikeShopSystem systemToLoad = new BikeShopSystem();
		try
		{
			file = new FileInputStream("state.ser");
	        in = new ObjectInputStream(file);
	        systemToLoad = (BikeShopSystem)in.readObject();
	        in.close();
	        file.close();
		}
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
		return systemToLoad;
	}
}
