package bikeShop;

import java.io.Serializable;

public class Accessory extends Item implements Serializable{
	private static final long serialVersionUID = 1092290525436755956L;

	public Accessory(double dailyRentalFee, double RentalCharge, double price, String name) {
		super(dailyRentalFee, RentalCharge, price, name);
	}

}
