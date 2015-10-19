package bikeShop;
import javax.swing.*;

import java.awt.*;

public class MasterGUI extends JFrame {
	BikeShopSystem bss;
	public MasterGUI(BikeShopSystem bss)
	{
		this.bss = bss;
		JTabbedPane tp = new JTabbedPane();
		
		tp.addTab("Rent Item", new RentItemPanel(bss));
		this.add(tp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
