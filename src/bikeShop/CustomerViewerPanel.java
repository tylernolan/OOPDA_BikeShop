package bikeShop;
import java.awt.*;
import javax.swing.*;
<<<<<<< HEAD
<<<<<<< HEAD
public class CustomerViewerPanel extends JPanel implements Updateable{
	private BikeShopSystem bss;
	private JComboBox<Rental> customerRentedItems;
	private JLabel customerName;
	private JLabel customerBalance;
	private JComboBox<Customer> customers;
=======
public class CustomerViewerPanel extends JPanel{
	BikeShopSystem bss;
>>>>>>> parent of 43b4765... added methods for rentals to BikeShopSystem. Added code to CustomerViewerPanel. Deprecated GenerateReceipt() in bikeshopsystem. Changed the way Rentals are stored in customer objects.
=======
public class CustomerViewerPanel extends JPanel{
	BikeShopSystem bss;
>>>>>>> parent of 43b4765... added methods for rentals to BikeShopSystem. Added code to CustomerViewerPanel. Deprecated GenerateReceipt() in bikeshopsystem. Changed the way Rentals are stored in customer objects.
	public CustomerViewerPanel(BikeShopSystem bss)
	{
		setLayout(new FlowLayout());
		customers = new JComboBox(bss.getCustomers().toArray());
		
		JFrame customerDataFrame = new JFrame();
		JLabel customerName = new JLabel("");
		JLabel customerBalance = new JLabel("");
		JLabel customerRentedItems = new JLabel("");
		customerDataFrame.add(customerName);
		customerDataFrame.add(customerBalance);
		customerDataFrame.add(customerRentedItems);
		
		this.add(customers);
<<<<<<< HEAD
<<<<<<< HEAD
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
<<<<<<< HEAD
	//public class ReturnItemListener implements ActionListener
	//{
		//public void actionPerformed(ActionEvent e)
		//{
			//bss.
		//}
	//}
=======
	public class ReturnItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bss.returnItem((Customer)customers.getSelectedItem(),(Rental)customerRentedItems.getSelectedItem());
			update(bss);
		}
=======
		this.add(customerDataFrame)
		
>>>>>>> parent of 43b4765... added methods for rentals to BikeShopSystem. Added code to CustomerViewerPanel. Deprecated GenerateReceipt() in bikeshopsystem. Changed the way Rentals are stored in customer objects.
=======
		this.add(customerDataFrame)
		
>>>>>>> parent of 43b4765... added methods for rentals to BikeShopSystem. Added code to CustomerViewerPanel. Deprecated GenerateReceipt() in bikeshopsystem. Changed the way Rentals are stored in customer objects.
	}
>>>>>>> a42130c51369f47e3b8cd85f3b97fdf85a5b9f15
	public class CustomerBoxListener implements ItemListener
	{
		public void itemStateChanged()
		{
			
		}
	}
}
