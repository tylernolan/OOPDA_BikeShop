package bikeShop;

import java.io.Serializable;

public abstract class Item implements Serializable{

	private static final long serialVersionUID = 43934718897464571L;
	private double dailyRentalFee;
	private double rentalDeposit;
	private double price;
	private boolean isRented;
	private Customer rentee;
	private String name;
	/**
	 * Abstract class for items in the bike shop
	 * @param dailyRentalFee the fee to rent the item per day
	 * @param RentalCharge the cost of renting the item up front
	 * @param price the price of purchasing the item
	 * @param name the name of the item
	 */
	public Item(double dailyRentalFee, double RentalCharge, double price, String name)
	{
		//I don't think RentalCharge is used for anything. Possibly removable. 
		this.isRented = false;
		this.dailyRentalFee = dailyRentalFee;
		this.rentalDeposit = RentalCharge;
		this.name = name;
		this.price = price;
	}
	public String getName()
	{
		return this.name;
	}
	public boolean isRented()
	{
		return this.isRented;
	}
	public void rentItem()
	{
		this.isRented = true;
	}
	public void returnItem()
	{
		this.isRented = false;
	}
	public double getPrice()
	{
		return this.price;
	}
	public double getDailyRentalFee() {
		return dailyRentalFee;
	}

	public void setDailyRentalFee(double dailyRentalFee) {
		this.dailyRentalFee = dailyRentalFee;
	}

	public double getRentalDeposit() {
		return rentalDeposit;
	}

	public void setRentalDeposit(double rentalDeposit) {
		this.rentalDeposit = rentalDeposit;
	}

	public Customer getRentee() {
		return rentee;
	}

	public void setRenteeItem(Customer rentee) {
		this.rentee = rentee;
	}
	@Override public String toString()
	{
		return this.name;
	}
	@Override public boolean equals(Object obj)
	{
		try
		{
			Item i = (Item)obj;
			if (i.getName() == this.getName())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}

}
