package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.DialogManipulation;

public class LicenceDialog {
	
	public static JDialog dialogLicence = new JDialog(WelcomeDialog.getWelcomeDialog());
	public static JButton jbOdustani, jbPrethodno, jbSledece;
	public static JCheckBox jbAgree;
	
	public LicenceDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		dialogLicence.setSize(screenWidth/2, screenHeight/2);
		dialogLicence.setTitle("Excel 1.0.0");
		dialogLicence.setLocationRelativeTo(null);
		
		
		JPanel licencePanel = new JPanel(new BorderLayout());
		JTextArea txtLicence = new JTextArea("Ovde treba da pise nesto pametno",15,60);
		
		JScrollPane scroll = new JScrollPane(txtLicence);
		licencePanel.add(scroll, BorderLayout.NORTH);
		
		jbAgree = new JCheckBox("Saglasan sam sa uslovima licence");
		jbAgree.addActionListener(new DialogManipulation());
		
		jbOdustani = new JButton("Odustani");
		jbOdustani.addActionListener(new DialogManipulation());
		
		jbPrethodno = new JButton("Prethodno");
		jbPrethodno.addActionListener(new DialogManipulation());
		
		jbSledece = new JButton("Sledece");
		jbSledece.addActionListener(new DialogManipulation());			
		
		JPanel lowerPanelLicence = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel centerPanelLicence = new JPanel();
		
		licencePanel.add(jbAgree, BorderLayout.CENTER);
		lowerPanelLicence.add(jbOdustani);
		lowerPanelLicence.add(jbPrethodno);
		lowerPanelLicence.add(jbSledece);
		
		//panel.add(centerPanel, BorderLayout.CENTER);
		licencePanel.add(lowerPanelLicence, BorderLayout.SOUTH);
		dialogLicence.add(licencePanel);
		
		dialogLicence.setVisible(true);
	}
	
	public static JCheckBox getJbAgree() {
		return jbAgree;
	}

	public static void setJbAgree(JCheckBox jbAgree) {
		LicenceDialog.jbAgree = jbAgree;
	}

	public static JButton getJbOdustani() {
		return jbOdustani;
	}

	public static void setJbOdustani(JButton jbOdustani) {
		LicenceDialog.jbOdustani = jbOdustani;
	}

	public static JButton getJbPrethodno() {
		return jbPrethodno;
	}

	public static void setJbPrethodno(JButton jbPrethodno) {
		LicenceDialog.jbPrethodno = jbPrethodno;
	}

	public static JButton getJbSledece() {
		return jbSledece;
	}

	public static void setJbSledece(JButton jbSledece) {
		LicenceDialog.jbSledece = jbSledece;
	}
	
	public static JDialog getLicenceDialog() {
		return dialogLicence; 
	}
}
