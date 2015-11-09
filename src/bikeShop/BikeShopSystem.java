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
/**
 * the system that handles the interactions between the various objects used in the bike shop.
 * @author Tyler
 *
 */
public class BikeShopSystem implements Serializable{
	private static final long serialVersionUID = -7876747047024597307L;
	private ArrayList<Item> inventory;
	private HashSet<Customer> customers;
	private ArrayList<Rental> ongoingRentals;
	private Receipt currentReceipt;
	/**
	 * default constructor, initializes empty ArrayLists for inventory and ongoing rentals, and an empty HashSet for a list of customers.
	 */
	public BikeShopSystem()
	{
		this.inventory = new ArrayList<Item>();
		this.customers = new HashSet<Customer>();
		this.ongoingRentals = new ArrayList<Rental>();
	}
	/**
	 * Generates a receipt object 
	 * @deprecated
	 * @param items the items in the customer's order
	 * @param customer the customer purchasing the item
	 * @return the receipt object
	 */
	public Receipt generateReceipt(HashMap<Item, Integer> items, Customer customer) 
	{
		Receipt receipt = new Receipt(items, customer);
		return receipt;
	}
	public double returnItem(Customer c, Rental r)
	{
		if (this.currentReceipt == null) this.currentReceipt = new Receipt(c);
		this.inventory.add(r.getItem());
		double amtDue = c.returnItem(r);
		this.currentReceipt.returnItem(r);
		return amtDue;
	}
	@Deprecated
	public Rental rentItem(Customer c, Item i, int term)
	{
		if (this.currentReceipt == null) this.currentReceipt = new Receipt(c);
		Rental r = new Rental(c, i, term);
		c.rentItem(i, r);
		return r;
	}
	/**
	 * rents an item to a customer for a term, adds the rental to our arraylist of ongoing rentals. 
	 * @param rentee the person renting the item
	 * @param item the item being rented
	 * @param rentalTerm the length of time the item is being rented for before the rentee is charged a late fee
	 * @return the rental object created by the method. 
	 */
	public Rental generateRental(Customer rentee, Item item, int rentalTerm)
	{
		if (this.currentReceipt == null) this.currentReceipt = new Receipt(rentee);
		Rental rental =  new Rental(rentee, item, rentalTerm, new Date());
		this.inventory.remove(item);
		currentReceipt.addRentalItem(rental);
		rentee.rentItem(item, rental);
		this.ongoingRentals.add(rental);
		return rental;
		
	}
	/**
	 * order new bikes for the bike shop
	 * @param thingsToOrder a hashmap of item:quantity pairs
	 * @return an order object
	 */
	public void orderBikes(HashMap<Item, Integer> thingsToOrder)
	{
		for(Item item:thingsToOrder.keySet()){
			for(int i=0;i<=thingsToOrder.get(item);i++){
				addItemToInventory(item);
			}
		}
	}
	public HashSet<Customer> getCustomers()
	{
		return this.customers;
	}
	public ArrayList<Item> getInventory()
	{
		return this.inventory;
	}
	/**
	 * adds an item to the shop's inventory
	 * @param itemToAdd the item to add
	 */
	public void addItemToInventory(Item itemToAdd)
	{
		inventory.add(itemToAdd);
	}
	/**
	 * Call after completing a sale.
	 * @return the sales receipt for the customer
	 */
	public Receipt checkout()
	{
		Receipt ret = currentReceipt;
		this.currentReceipt = null;
		return ret;
	}
	/**
	 * sells an item to the specified customer
	 * @param customer the customer buying the item
	 * @param item the item being purchased.
	 */
	public void sellItem(Customer customer, Item item)
	{
		if (this.currentReceipt == null) this.currentReceipt = new Receipt(customer);
		this.currentReceipt.addSaleItem(item);
		customer.purchaseItem(item);
		inventory.remove(item);
	}
	/**
	 * adds a new customer to the system, only if their name has both a first and last name.
	 * @param name the name of the customer, with first and last name seperated by a space. 
	 * @return true if the customer was added successfully.
	 */
	public void newCustomer(String name) throws CantCreateCustomerException
	{
		if(name.split(" ").length == 2)
		{
			for (Customer c : customers)
				if (c.getName().equals(name)) {
					throw new CantCreateCustomerException("Already has a customer by that name");
				}
			customers.add(new Customer(name));
			System.out.println(customers);
			
		}
		
		else 
		{
			throw new CantCreateCustomerException("Supply both first and last name");
			
		}
	}
	/**
	 * saves the state of all objects in the shop in state.ser to be loaded later with loadShopState.
	 */
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
			System.out.println("save success");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public Receipt getCurrentReceipt()
	{
		return this.currentReceipt;
	}
	/**
	 * loads a BikeShopSystem object from state.ser
	 * @return the BikeShopSystem object stored in state.ser
	 */
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
		System.out.println(systemToLoad.getCustomers());
		return systemToLoad;
	}
	public HashSet<Item> generateOrderableItems()
	{
		HashSet<Item> ret = new HashSet<>();
		ret.add(new Accessory(5,10,50,"helmet"));
		ret.add(new Bike(10,15,500,"bike", "coolBike2000","2000","0922000",Gender.MALE));
		ret.add(new Bike(20,25,1000,"fancy bike", "Awesome Bike 2001","2001","0922000",Gender.FEMALE));
		return ret;
	}
}
