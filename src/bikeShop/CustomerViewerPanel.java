package bikeShop;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class CustomerViewerPanel extends JPanel implements Updateable{
	private BikeShopSystem bss;
	private JComboBox<Rental> customerRentedItems;
	private JLabel customerName;
	private JLabel customerBalance;
	private JComboBox<Customer> customers;
	public CustomerViewerPanel(BikeShopSystem bss)
	{
		setLayout(new FlowLayout());
		customers = new JComboBox(bss.getCustomers().toArray());
		customers.addItemListener(new CustomerBoxListener());
		
		JPanel customerDataPanel = new JPanel();
		customerName = new JLabel("");
		customerBalance = new JLabel("");
		customerRentedItems = new JComboBox();
		
		
		customerDataPanel.add(customerName);
		customerDataPanel.add(customerBalance);
		customerDataPanel.add(customerRentedItems);
		
		JButton returnItemButton = new JButton("Return Item");
		returnItemButton.addActionListener(new ReturnItemListener());
		
		this.add(customers);
		this.add(customerDataPanel);
		this.add(returnItemButton);
	}
	public void update(BikeShopSystem bss)
	{
		this.bss = bss;
		this.customers.removeAllItems();
		customers.removeAllItems();
		for (Customer c : bss.getCustomers()){
			customers.addItem(c);
		}
		customerRentedItems.removeAllItems();
		customerName.setText("");
		customerBalance.setText("");
	}
	public class ReturnItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bss.returnItem((Customer)customers.getSelectedItem(),(Rental)customerRentedItems.getSelectedItem());
			update(bss);
		}
	}
	public class CustomerBoxListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			Customer c = (Customer)e.getItem();
			customerName.setText(c.toString());
			customerBalance.setText(String.valueOf(c.getAccountBalance()));
			
			customerRentedItems.removeAllItems();
			for (Rental i : c.getRentedItems())
			{
				customerRentedItems.addItem(i);
			}
			
		}
	}
}
