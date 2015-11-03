package bikeShop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
public class AddCustomerPanel extends JPanel implements Updateable{
	private JTextField nameField;
	private BikeShopSystem bss;
	
	public AddCustomerPanel(BikeShopSystem bss)
	{
		this.bss = bss;
		JPanel namePanel = new JPanel();
		nameField = new JTextField(10);
		JLabel nameLabel = new JLabel("Name: ");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JButton addButton = new JButton("Add Customer");
		addButton.addActionListener(new AddCustomerButtonListener());
		
		this.add(namePanel);
		this.add(addButton);
	}
	public void update(BikeShopSystem bss)
	{
		this.bss = bss;
	}
	private class AddCustomerButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				bss.newCustomer(nameField.getText());
			}
			catch (CantCreateCustomerException exc){
				JOptionPane.showMessageDialog(null, exc.getMessage(),"Invalid Name", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
