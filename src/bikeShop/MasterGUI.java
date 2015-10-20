package bikeShop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class MasterGUI extends JFrame {
	BikeShopSystem bss;
	SellItemPanel sip;
	AddCustomerPanel acp;
	RentItemPanel rip;
	public MasterGUI(BikeShopSystem bss)
	{
		this.bss = bss;
		JTabbedPane tp = new JTabbedPane();
		sip = new SellItemPanel(bss);
		acp = new AddCustomerPanel(bss);
		rip = new RentItemPanel(bss);
		tp.addTab("Sell Item", sip);
		tp.addTab("Rent Item", rip);
		tp.addTab("Add Customer", acp);
		this.add(tp);
		//ChangeListener changeListener = new ChangeListener(){
		//	public void stateChanged(ChangeEvent changeEvent)
		//	{
		//		sip = new SellItemPanel(bss);
		//		acp = new AddCustomerPanel(bss);
		//		rip = new RentItemPanel(bss);
		//		pack();
		//	}
		//};
		//tp.addChangeListener(changeListener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
