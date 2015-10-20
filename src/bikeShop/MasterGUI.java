package bikeShop;
import javax.swing.*;

import java.awt.*;

public class MasterGUI extends JFrame {
	BikeShopSystem bss;
	public MasterGUI(BikeShopSystem bss)
	{
		this.bss = bss;
		JTabbedPane tp = new JTabbedPane();
		
		tp.addTab("Sell Item", new SellItemPanel(bss));
		tp.addTab("Rent Item", new RentItemPanel(bss));
		tp.addTab("Add Customer", new addCustomerPanel(bss));
		this.add(tp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
