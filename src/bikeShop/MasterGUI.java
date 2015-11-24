package bikeShop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MasterGUI extends JFrame {
	private ArrayList<Updateable> panels = new ArrayList<>();;
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
		tp.addTab("Sell Item", sip);
		tp.addTab("Rent Item", rip);
		tp.addTab("Add Customer", acp);
		tp.addTab("Customer Viewer", cvp);
		tp.addTab("Active Receipt", arp);
		tp.addTab("Save/Load", slp);
		tp.addTab("Order Items", oip);
		panels.add(oip);
		panels.add(sip);
		panels.add(rip);
		panels.add(acp);
		panels.add(cvp);
		panels.add(arp);
		this.setMinimumSize(new Dimension(800,600));
		this.add(tp);
		ChangeListener changeListener = new ChangeListener(){
			public void stateChanged(ChangeEvent changeEvent)
			{
				for(Updateable p : panels) p.update(bss);
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
