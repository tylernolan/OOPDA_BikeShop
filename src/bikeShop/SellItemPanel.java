package bikeShop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SellItemPanel extends JPanel {
	
	private JComboBox customers, items;
	private BikeShopSystem bss;
	private JButton sellButton;
	private Item selectedItem;
	private Customer selectedCustomer;
	
	private ButtonGroup bg;
	
	public SellItemPanel(BikeShopSystem bss) {
				
		JPanel customerPanel = new JPanel();
		JLabel customerLabel = new JLabel("Customers: ");
		customers = new JComboBox(bss.getCustomers().toArray());
		
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
		private class SellButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				selectedCustomer = (Customer)customers.getSelectedItem();
				selectedItem = (Item)items.getSelectedItem();
				
				bss.sellItem(selectedCustomer, selectedItem);
				
			}
		}
				
	}

