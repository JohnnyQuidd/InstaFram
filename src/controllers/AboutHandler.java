package controllers;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import view.MainFrame;

public class AboutHandler implements MenuListener{

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		try {
//			String string1 = "Autor:    Petar Kovacevic\nFakultet tehnickih nauka - Novi sad\n"
//					+ "Verzija    1.0";
			JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("autor"),
					MainFrame.getResourceBundle().getString("o_nama"), JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
}
