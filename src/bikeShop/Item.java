package bikeShop;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 43934718897464571L;
	private double dailyRentalFee;
	private double dailyRentalCharge;
	private double price;
	private boolean isRented;
	private Customer rentee;
	private String name;
	
	public Item(double dailyRentalFee, double dailyRentalCharge, double price, String name)
	{
		this.isRented = false;
		this.dailyRentalFee = dailyRentalFee;
		this.dailyRentalCharge = dailyRentalCharge;
		this.name = name;
		this.price = price;
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
		return this.getPrice();
	}
	public double getDailyRentalFee() {
		return dailyRentalFee;
	}

	public void setDailyRentalFee(double dailyRentalFee) {
		this.dailyRentalFee = dailyRentalFee;
	}

	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public void setDailyRentalCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
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

}
