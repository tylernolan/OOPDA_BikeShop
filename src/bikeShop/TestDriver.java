package bikeShop;

public class TestDriver {

	public static void main(String[] args) {
		//BikeShopSystem sys = new BikeShopSystem();
		//sys.addItemToInventory(new Item(5,10,"helmet"));
		//sys.addItemToInventory(new Item(10,15,"bike"));
		//sys.addItemToInventory(new Item(20,25,"fancy bike"));
		//sys.newCustomer("Tyler Nolan");
		//sys.saveShopState();
		
		BikeShopSystem sys = BikeShopSystem.loadShopState();
		System.out.println(sys.getCustomers().toString());
		System.out.println(sys.getInventory().toString());
	}

}
