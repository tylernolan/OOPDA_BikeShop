package bikeShop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SellItemPanel extends JPanel implements Updateable{
	
	private JComboBox<Customer> customers;
	private JComboBox<Item> items;
	private BikeShopSystem bss;
	private JButton sellButton;
	private Item selectedItem;
	private Customer selectedCustomer;
	
	private ButtonGroup bg;
	
	public SellItemPanel(BikeShopSystem bss) {
		this.bss = bss;
		JPanel customerPanel = new JPanel();
		JLabel customerLabel = new JLabel("Customers: ");
		customers = new JComboBox();//bss.getCustomers().toArray());
		customers.setModel(new DefaultComboBoxModel(bss.getCustomers().toArray()));
		
		customerPanel.add(customerLabel);
		customerPanel.add(customers);
		
		JPanel itemPanel = new JPanel();
		JLabel itemLabel = new JLabel("Items: ");
		items = new JComboBox(bss.getInventory().toArray());
		
		
		itemPanel.add(itemLabel);
		itemPanel.add(items);
		
		
		sellButton = new JButton("Sell item");
		sellButton.addActionListener(new SellButtonListener());

		setLayout(new FlowLayout());
		
		add(customerPanel);
		add(itemPanel);
		add(sellButton);
	}
	public void update(BikeShopSystem bss)
	{
		this.bss = bss;
		customers.removeAllItems();
		for (Customer c : bss.getCustomers()){
			customers.addItem(c);
		}
		items.removeAllItems();
		for (Item i : bss.getInventory()){
			items.addItem(i);
		}
	}
		private class SellButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				selectedCustomer = (Customer)customers.getSelectedItem();
				selectedItem = (Item)items.getSelectedItem();
				bss.sellItem(selectedCustomer, selectedItem);
				update(bss);
				
			}
		}
				
	}

