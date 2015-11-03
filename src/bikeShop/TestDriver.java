package bikeShop;

public class TestDriver {

	public static void main(String[] args) {
		BikeShopSystem sys = new BikeShopSystem();
		//BikeShopSystem sys = BikeShopSystem.loadShopState();
		sys.addItemToInventory(new Accessory(5,10,50,"helmet"));
		sys.addItemToInventory(new Bike(10,15,500,"bike", "coolBike2000","2000","0922000",Gender.MALE));
		sys.addItemToInventory(new Bike(20,25,1000,"fancy bike", "Awesome Bike 2001","2001","0922000",Gender.FEMALE));
		try {
			sys.newCustomer("Tyler Nolan");
			sys.newCustomer("Dillon Browne");
		}
		catch(CantCreateCustomerException e){
			
		}
		new MasterGUI(sys);
		sys.saveShopState();
		
		System.out.println(sys.getCustomers().toString());
		System.out.println(sys.getInventory().toString());
	}

}
