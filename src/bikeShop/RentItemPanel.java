package bikeShop;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class RentItemPanel extends JFrame{
	private JComboBox customers, items;
	private Item selectedItem;
	private Customer selectedCustomer;
	private JButton rentButton;
	private BikeShopSystem bss;
	private JTextField rentalTermBox;
	
	public RentItemPanel(BikeShopSystem bss)
	{
		JPanel customerPanel = new JPanel();
		JLabel myLabel = new JLabel("Customers:");
		customers = new JComboBox(bss.getCustomers().toArray());
		
		customerPanel.add(myLabel);
		customerPanel.add(customers);
		
		JPanel itemPanel = new JPanel();
		JLabel myLabel2 = new JLabel("Items: ");
		items = new JComboBox(bss.getInventory().toArray());
		
		itemPanel.add(myLabel2);
		itemPanel.add(items);
		
		rentalTermBox = new JTextField();
		this.bss = bss;
		rentButton = new JButton("Rent Item");
		
		this.setLayout(new FlowLayout());
		this.add(customerPanel);
		this.add(itemPanel);
	}
	
	private class RentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectedCustomer = (Customer)customers.getSelectedItem();
			selectedItem = (Item)items.getSelectedItem();
			int rentalTerm = Integer.parseInt(rentalTermBox.getText());
			bss.generateRental(selectedCustomer, selectedItem, rentalTerm);
			
		}
	}
}
