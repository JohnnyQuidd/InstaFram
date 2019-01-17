package controllers;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import view.MainFrame;

public class HelpAction implements MenuListener{

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		try {
			//String string1 = "Uputstvo za upotrebu radnog alata InstaFram je u izradi.";
			JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("u_izradi"),
					MainFrame.getResourceBundle().getString("pomoc"), JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
