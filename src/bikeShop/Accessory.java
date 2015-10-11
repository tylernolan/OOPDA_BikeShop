package bikeShop;

import java.io.Serializable;
/**
 * Accessory class for items in the shop that aren't bikes, such as helmets, or custom parts.
 * @author Tyler
 *
 */
public class Accessory extends Item implements Serializable{
	private static final long serialVersionUID = 1092290525436755956L;
	/**
	 * Constructor for accessory objects
	 * @param dailyRentalFee the fee to rent the item per day
	 * @param RentalCharge the up-front cost to rent the item
	 * @param price the cost to buy the item
	 * @param name the name of the item
	 */
	public Accessory(double dailyRentalFee, double RentalCharge, double price, String name) {
		super(dailyRentalFee, RentalCharge, price, name);
	}

}
