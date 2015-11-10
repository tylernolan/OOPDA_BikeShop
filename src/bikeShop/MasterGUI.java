package bikeShop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;

public class MasterGUI extends JFrame {
	BikeShopSystem bss;
	SellItemPanel sip;
	AddCustomerPanel acp;
	ActiveReceiptPanel arp;
	RentItemPanel rip;
	SaveLoadPanel slp;
	OrderItemPanel oip;
	CustomerViewerPanel cvp;
	public MasterGUI(BikeShopSystem bss)
	{
		this.bss = bss;
		JTabbedPane tp = new JTabbedPane();
		sip = new SellItemPanel(bss);
		acp = new AddCustomerPanel(bss);
		rip = new RentItemPanel(bss);
		slp = new SaveLoadPanel(bss, this); //panel with options for serialization
		arp = new ActiveReceiptPanel(bss); //panel with checkout button, textbox with active receipt.
		oip = new OrderItemPanel(bss); //panel for ordering new items for the inventory.
		cvp = new CustomerViewerPanel(bss); //panel for viewing customer data, rentals, balance, etc.
		tp.addTab("Order Item", oip);
		tp.addTab("Sell Item", sip);
		tp.addTab("Rent Item", rip);
		tp.addTab("Add Customer", acp);
		tp.addTab("Active Receipt", arp);
		tp.addTab("Save/Load", slp);
		tp.addTab("Customer Viewer", cvp);
		this.setMinimumSize(new Dimension(800,600));
		this.add(tp);
		ChangeListener changeListener = new ChangeListener(){
			public void stateChanged(ChangeEvent changeEvent)
			{
				sip.update(getBSS());
				rip.update(getBSS());
				arp.update(getBSS());
				acp.update(getBSS());
				slp.update(getBSS());
				cvp.update(getBSS());
			}
		};
		tp.addChangeListener(changeListener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void setBSS(BikeShopSystem bss)
	{
		this.bss = bss;
	}
	public BikeShopSystem getBSS()
	{
		return this.bss;
	}
}
