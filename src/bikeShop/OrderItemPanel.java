package bikeShop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


public class OrderItemPanel extends JFrame{
	
	
	private JPanel itemPanel;
	private JComboBox<Item> items;
	private BikeShopSystem bss;
	private JButton orderButton;
	private JTextField quantityToAdd;
	private Item selectedItem;
	private JTextField itemList;
	private JButton submitButton;
	private JComboBox itemsAvailable;
	
	
	public OrderItemPanel(BikeShopSystem bss) {
		this.bss = bss;
		
		
		JPanel quantityPanel = new JPanel();
		JLabel quantityLabel = new JLabel("Quantity: ");
		quantityToAdd = new JTextField();
		
		
		
		quantityPanel.add(quantityLabel);
		quantityPanel.add(quantityToAdd);
		
		
		JPanel itemPanel = new JPanel();
		JLabel itemLabel = new JLabel("Items: ");
		itemsAvailable = new JComboBox();
		
		itemPanel.add(itemLabel);
		itemPanel.add(itemsAvailable);
		
		
		orderButton = new JButton("Order item");
		orderButton.addActionListener(new OrderButtonListener());
		
		submitButton = new JButton("Submit order");
		submitButton.addActionListener(new SubmitButtonListener());
		
		setLayout(new BorderLayout());
		JFrame centerFrame = new JFrame();
		centerFrame.add(orderButton);
		centerFrame.add(quantityToAdd);
		centerFrame.add(submitButton);
		
		add(itemsAvailable, BorderLayout.WEST);
		add(centerFrame, BorderLayout.CENTER);
		
	}
	
	private class OrderButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			Item itemSelected = (Item) itemsAvailable.getSelectedItem();
			int quantity = Integer.parseInt(quantityToAdd.getText());
			HashMap<Item, Integer> order = new HashMap<Item, Integer>();
			order.put(itemSelected, (Integer) quantity);
			bss.orderBikes(order);
			
		}
	}
	
	private class SubmitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	
	
	
	
}
