package bikeShop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
public class SaveLoadPanel extends JPanel implements Updateable{
	BikeShopSystem bss;
	MasterGUI mg;
	public SaveLoadPanel(BikeShopSystem bss, MasterGUI mg)
	{
		this.mg = mg;
		this.bss = bss;
		JButton saveButton = new JButton("Save Shop State");
		JButton loadButton = new JButton("Load Shop State");
		saveButton.addActionListener(new SaveButtonListener());
		loadButton.addActionListener(new LoadButtonListener());
		this.add(saveButton);
		this.add(loadButton);
	}
	public void update(BikeShopSystem bss)
	{
		this.bss = bss;
	}
	public class SaveButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bss.saveShopState();
		}
	}
	public class LoadButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bss = BikeShopSystem.loadShopState();
			mg.setBSS(bss);
		}
	}
}
