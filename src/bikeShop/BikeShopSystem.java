package bikeShop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class BikeShopSystem implements Serializable{
	private static final long serialVersionUID = -7876747047024597307L;
	private ArrayList<Item> inventory;
	private HashSet<Customer> customers;
	
	public BikeShopSystem()
	{
		this.inventory = new ArrayList<Item>();
		this.customers = new HashSet<Customer>();
	}
	public void addItemToInventory(Item itemToAdd)
	{
		inventory.add(itemToAdd);
	}
	public void sellItem(Item item)
	{
		inventory.remove(item);
	}
	public void newCustomer(String name)
	{
		customers.add(new Customer(name));
	}
	public void saveShopState() throws IOException
	{
		FileOutputStream file = new FileOutputStream("state.ser");
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(this);
		file.close();
		out.close();
	}
	public void loadShopState() throws IOException, ClassNotFoundException
	{
		FileInputStream file = new FileInputStream("state.ser");
        ObjectInputStream in = new ObjectInputStream(file);
        BikeShopSystem systemToLoad = (BikeShopSystem)in.readObject();
        in.close();
        file.close();
	}
}
