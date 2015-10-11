package bikeShop;

import java.io.Serializable;
/**
 * class for bike objects
 * @author Tyler
 *
 */
public class Bike extends Item implements Serializable{

	private static final long serialVersionUID = -8640415053920505415L;
	private String bikeType;
	private String bikeModel;
	private String bikeNumber;
	private Gender gender;
	/**
	 * 
	 * Constructor for bike objects
	 * @param dailyRentalFee the fee to rent the item per day
	 * @param RentalCharge the up-front cost to rent the item
	 * @param price the cost to buy the item
	 * @param name the name of the item
	 * @param bikeType the type of bike, ex. Tandem, race, casual, etc. 
	 * @param bikeModel the model of the bike
	 * @param bikeNumber the bike's id number
	 * @param gender whether it is a mens or womens bike
	 */
	public Bike(double dailyRentalFee, double dailyRentalCharge, double price, String name, String bikeType, String bikeModel, String bikeNumber, Gender gender)
	{
		super(dailyRentalFee, dailyRentalCharge, price, name);
		this.bikeType = bikeType;
		this.bikeModel = bikeModel;
		this.bikeNumber = bikeNumber;
		this.gender = gender;
	}

	public String getBikeType() {
		return bikeType;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public String getBikeNumber() {
		return bikeNumber;
	}

	public Gender getGender() {
		return gender;
	}

}
