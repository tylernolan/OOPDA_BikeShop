package bikeShop;

public class TestDriver {

	public static void main(String[] args) {
//		BikeShopSystem sys = new BikeShopSystem();
//		sys.addItemToInventory(new Accessory(5,10,50,"Helmet"));
//		sys.addItemToInventory(new Accessory(5,10,50,"Helmet"));
//		sys.addItemToInventory(new Accessory(5,10,50,"Helmet"));
//		sys.addItemToInventory(new Accessory(5,10,50,"Water Bottle"));
//		sys.addItemToInventory(new Accessory(5,10,50,"Water Bottle"));
//		sys.addItemToInventory(new Accessory(5,10,50,"Water Bottle"));
//		sys.addItemToInventory(new Bike(10,15,500,"Road Bike Male", "RBY2015","2000","0922000",Gender.MALE));
//		sys.addItemToInventory(new Bike(10,15,500,"Road Bike Male", "RBY2015","2000","0922000",Gender.MALE));
//		sys.addItemToInventory(new Bike(10,15,500,"Road Bike Male", "RBY2015","2000","0922000",Gender.MALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"Mountain Bike Female", "MBX2015","2001","0922000",Gender.FEMALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"Mountain Bike Female", "MBX2015","2001","0922000",Gender.FEMALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"Mountain Bike Female", "MBX2015","2001","0922000",Gender.FEMALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"City Bike Female", "CBX2015","2001","0922000",Gender.FEMALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"City Bike Female", "CBX2015","2001","0922000",Gender.FEMALE));
//		sys.addItemToInventory(new Bike(20,25,1000,"City Bike Female", "CBX2015","2001","0922000",Gender.FEMALE));
//		try {
//			sys.newCustomer("Tyler Nolan");
//			sys.newCustomer("Dillon Browne");
//		}
//		catch(CantCreateCustomerException e){
//			
//		}
		BikeShopSystem sys = BikeShopSystem.loadShopState();
		Runtime.getRuntime().addShutdownHook(new ShutdownThread(sys));
		new MasterGUI(sys);
		
		System.out.println(sys.getCustomers().toString());
		System.out.println(sys.getInventory().toString());
	}

}
