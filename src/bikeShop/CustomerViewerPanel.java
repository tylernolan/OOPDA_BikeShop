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
		
		JFrame customerDataFrame = new JFrame();
		customerName = new JLabel("");
		customerBalance = new JLabel("");
		customerRentedItems = new JComboBox();
		customerRentedItems.addItemListener(new CustomerBoxListener());
		
		customerDataFrame.add(customerName);
		customerDataFrame.add(customerBalance);
		customerDataFrame.add(customerRentedItems);
		
		JButton returnItemButton = new JButton("Return Item");
		
		this.add(customers);
		this.add(customerDataFrame);
		this.add(returnItemButton);
	}
	public void update(BikeShopSystem bss)
	{
		this.bss = bss;
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
