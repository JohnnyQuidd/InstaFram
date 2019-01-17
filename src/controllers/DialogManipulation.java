package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import view.CustomDialog;
import view.GuideDialog;

public class DialogManipulation implements ActionListener {
	CardLayout c;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == GuideDialog.getJbSledeceWelcome()) {
			c = GuideDialog.getC1();
			c.show(GuideDialog.getGuidePanel(), "2");
						
		}
		if(e.getSource() == GuideDialog.getJbOdustaniWelcome()) {
			GuideDialog.getGuideDialog().dispose();
			GuideDialog.getGuideDialog().setVisible(false);
		}
		
		if(e.getSource() == GuideDialog.getJbOdustaniLicence()) {
			GuideDialog.getGuideDialog().dispose();
			GuideDialog.getGuideDialog().setVisible(false);
			
		}if(e.getSource() == GuideDialog.getJbPrethodnoLicence()) {
			c = GuideDialog.getC1();
			c.show(GuideDialog.getGuidePanel(), "1");
		} if(e.getSource() == GuideDialog.getJbSledeceLicence()) {
			if(!GuideDialog.getJbAgreeLicence().isSelected()) {
				JOptionPane.showMessageDialog(GuideDialog.getGuideDialog(), "Morate biti saglasni sa uslovima", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			} else {
				c = GuideDialog.getC1();
				c.show(GuideDialog.getGuidePanel(), "3");
			}
		} if(e.getSource() == GuideDialog.getJbOdustaniOdrediste()) {
			GuideDialog.getGuideDialog().dispose();
			GuideDialog.getGuideDialog().setVisible(false);
		} 
		if(e.getSource()== GuideDialog.getJbSledeceOdrediste()) {
			if(GuideDialog.getTxtOdrediste().getText().toString().length()!=0) {
				
				String source = GuideDialog.getSource();
				String destination = GuideDialog.getTxtOdrediste().getText().toString();   
				
				System.out.println("IZ: " + source);
			    System.out.println("U : " + destination);
				try {
					c = GuideDialog.getC1();
					c.show(GuideDialog.getGuidePanel(), "4");
				    ZipFile zipFile = new ZipFile(source);
				    zipFile.extractAll(destination);
				} catch (ZipException ee) {
				    ee.printStackTrace();
				}
				
				
			} else {
				JOptionPane.showMessageDialog(GuideDialog.getGuideDialog(), "Morate uneti apsolutnu putanju", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		} 
		if(e.getSource() == GuideDialog.getJbPrethodnoOdrediste()) {
			c = GuideDialog.getC1();
			c.show(GuideDialog.getGuidePanel(), "2");
		}
		if(e.getSource() == GuideDialog.getJbKraj()) {
			GuideDialog.getGuideFrame().dispose();
			GuideDialog.getGuideFrame().setVisible(false);
		}
	}

}
