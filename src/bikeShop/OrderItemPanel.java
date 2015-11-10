package bikeShop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


public class OrderItemPanel extends JPanel{
	
	
	private JPanel itemPanel;
	private JComboBox<Item> items;
	private BikeShopSystem bss;
	private JTextField quantityToAdd;
	private Item selectedItem;
	private JButton submitButton;
	private JComboBox itemsAvailable;
	
	
	public OrderItemPanel(BikeShopSystem bss) {
		this.bss = bss;
		
		
		JPanel quantityPanel = new JPanel();
		JLabel quantityLabel = new JLabel("Quantity: ");
		quantityToAdd = new JTextField(5);
		
		
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityToAdd);
		
		
		JPanel itemPanel = new JPanel();
		JLabel itemLabel = new JLabel("Items: ");
		itemsAvailable = new JComboBox(bss.generateOrderableItems().toArray());
		
		itemPanel.add(itemLabel);
		itemPanel.add(itemsAvailable);
		
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonListener());
		
		setLayout(new BorderLayout());
		JPanel centerFrame = new JPanel();
		centerFrame.add(quantityPanel);
		centerFrame.add(quantityToAdd);
		centerFrame.add(submitButton);
		
		add(itemsAvailable, BorderLayout.WEST);
		add(centerFrame, BorderLayout.CENTER);
		
	}
	
	private class SubmitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
			Item itemSelected = (Item) itemsAvailable.getSelectedItem();
			int quantity = Integer.parseInt(quantityToAdd.getText());
			HashMap<Item, Integer> order = new HashMap<Item, Integer>();
			order.put(itemSelected, (Integer) quantity);
			bss.orderBikes(order);
			}
			catch(NumberFormatException exc){
				;
			}
			
		}
	}
	
	
	
	
	
	
}
