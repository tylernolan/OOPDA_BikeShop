package bikeShop;

public class ShutdownThread extends Thread{
	BikeShopSystem bss;
	public ShutdownThread(BikeShopSystem bss)
	{
		super();
		this.bss = bss;
	}
	public void run()
	{
		bss.saveShopState();
	}
}
