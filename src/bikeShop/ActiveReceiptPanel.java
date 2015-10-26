package bikeShop;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ActiveReceiptPanel extends JPanel{
	JTextPane receiptBox = new JTextPane();
	JButton checkoutButton = new JButton();
	BikeShopSystem bss;
	public ActiveReceiptPanel(BikeShopSystem bss)
	{
		this.bss = bss;
		this.setLayout(new FlowLayout());
		setText();
		checkoutButton = new JButton("Checkout");
		checkoutButton.addActionListener(new checkoutListener());
		
		this.add(receiptBox);
		this.add(checkoutButton);
	}
	public void setText()
	{
		try{
			receiptBox.setText(bss.getCurrentReceipt().toString());
		}
		catch (NullPointerException e)
		{
			receiptBox.setText("");
		}
	}
	public void update()
	{
		setText();
	}
	public class checkoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bss.checkout();
		}
	}
}
