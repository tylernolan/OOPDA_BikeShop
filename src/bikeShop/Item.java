package bikeShop;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 43934718897464571L;
	private double dailyRentalFee;
	private double dailyRentalCharge;
	private Customer rentee;
	private String name;
	
	public Item(double dailyRentalFee, double dailyRentalCharge, String name)
	{
		this.dailyRentalFee = dailyRentalFee;
		this.dailyRentalCharge = dailyRentalCharge;
		this.name = name;
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

}
