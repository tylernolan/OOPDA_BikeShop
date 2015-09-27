package bikeShop;

import java.io.Serializable;

public class Bike extends Item implements Serializable{

	private static final long serialVersionUID = -8640415053920505415L;
	private String bikeType;
	private String bikeModel;
	private String bikeNumber;
	private String gender;
	
	public Bike(double dailyRentalFee, double dailyRentalCharge, double price, String name, String bikeType, String bikeModel, String bikeNumber, String gender)
	{
		super(dailyRentalFee, dailyRentalCharge, price, name);
		this.bikeType = bikeType;
		this.bikeModel = bikeModel;
		this.bikeNumber = bikeNumber;
		this.gender = gender;	
	}

}
