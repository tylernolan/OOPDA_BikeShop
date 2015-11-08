package bikeShop;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class RentItemPanel extends JPanel implements Updateable{
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
		
		JPanel termPanel = new JPanel();
		rentalTermBox = new JTextField(5);
		JLabel myLabel3 = new JLabel("Rental Term: ");
		
		termPanel.add(myLabel3);
		termPanel.add(rentalTermBox);
		
		this.bss = bss;
		rentButton = new JButton("Rent Item");
		rentButton.addActionListener(new RentButtonListener());
		this.setLayout(new FlowLayout());
		this.add(customerPanel);
		this.add(itemPanel);
		this.add(termPanel);
		this.add(rentButton);
		
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
	
	private class RentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectedCustomer = (Customer)customers.getSelectedItem();
			selectedItem = (Item)items.getSelectedItem();
			try{
				int rentalTerm = Integer.parseInt(rentalTermBox.getText());
				bss.generateRental(selectedCustomer, selectedItem, rentalTerm);
				update(bss);
			}
			catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null, "Please enter a number in the term box","Invalid Term", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
}
