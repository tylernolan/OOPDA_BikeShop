package bikeShop;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ActiveReceiptPanel extends JPanel implements Updateable{
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
	public void update(BikeShopSystem bss)
	{
		setText();
		this.bss = bss;
	}
	public class checkoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
			Receipt receipt = bss.checkout(); 
			receipt.generateReceipt();
			update(bss);
			}
			catch(NullPointerException exc){
				;
			}
		}
	}
}
