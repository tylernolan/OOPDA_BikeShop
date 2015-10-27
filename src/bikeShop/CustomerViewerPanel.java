package bikeShop;
import java.awt.*;
import javax.swing.*;
public class CustomerViewerPanel extends JPanel{
	BikeShopSystem bss;
	public CustomerViewerPanel(BikeShopSystem bss)
	{
		setLayout(new FlowLayout());
		JComboBox<Customer> customers = new JComboBox(bss.getCustomers().toArray());
		
		JFrame customerDataFrame = new JFrame();
		JLabel customerName = new JLabel("");
		JLabel customerBalance = new JLabel("");
		JLabel customerRentedItems = new JLabel("");
		customerDataFrame.add(customerName);
		customerDataFrame.add(customerBalance);
		customerDataFrame.add(customerRentedItems);
		
		this.add(customers);
		this.add(customerDataFrame)
		
	}
	public class CustomerBoxListener implements ItemListener
	{
		public void itemStateChanged()
		{
			
		}
	}
}
