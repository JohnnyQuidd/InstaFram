package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.FileOpener;

public class OdredisteDialog {
	public JLabel lblOdrediste;
	public static JTextField txtOdrediste;
	public static JButton jbOdustani, jbPrethodno, jbSledece, jbTraziOdrediste;
	public static JDialog dialogOdrediste = new JDialog(LicenceDialog.getLicenceDialog());
	
	public OdredisteDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		dialogOdrediste.setSize(screenWidth/2, screenHeight/2);
		dialogOdrediste.setTitle("Excel 1.0.0");
		dialogOdrediste.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel upperPanel = new JPanel();
		upperPanel.setPreferredSize(new Dimension(10,150));
		JPanel centerPanel = new JPanel(new FlowLayout());
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		jbOdustani = new JButton("Odustani");
		jbPrethodno = new JButton("Prethodno");
		jbSledece = new JButton("Sledece");
		jbTraziOdrediste = new JButton("...");
		jbTraziOdrediste.addActionListener(new FileOpener());
		
		
		
		lblOdrediste = new JLabel("Odrediste");
		txtOdrediste = new JTextField("", 30);
		
		centerPanel.add(lblOdrediste);
		centerPanel.add(txtOdrediste);
		centerPanel.add(jbTraziOdrediste);
		
		mainPanel.add(upperPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		lowerPanel.add(jbOdustani);
		lowerPanel.add(jbPrethodno);
		lowerPanel.add(jbSledece);
		
		
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		
		dialogOdrediste.add(mainPanel);
		dialogOdrediste.setVisible(true);
		
	}
	
	public static JDialog getDialogOdrediste() {
		return dialogOdrediste;
	}

	public static void setDialogOdrediste(JDialog dialogOdrediste) {
		OdredisteDialog.dialogOdrediste = dialogOdrediste;
	}
	
	public static JTextField getTxtOdrediste() {
		return txtOdrediste;
	}

	public static void setTxtOdrediste(String txtOdrediste) {
		OdredisteDialog.txtOdrediste.setText(txtOdrediste);
	}

	public static JButton getJbOdustani() {
		return jbOdustani;
	}

	public static void setJbOdustani(JButton jbOdustani) {
		OdredisteDialog.jbOdustani = jbOdustani;
	}

	public static JButton getJbPrethodno() {
		return jbPrethodno;
	}

	public static void setJbPrethodno(JButton jbPrethodno) {
		OdredisteDialog.jbPrethodno = jbPrethodno;
	}

	public static JButton getJbSledece() {
		return jbSledece;
	}

	public static void setJbSledece(JButton jbSledece) {
		OdredisteDialog.jbSledece = jbSledece;
	}

	public static JButton getJbTraziOdrediste() {
		return jbTraziOdrediste;
	}

	public static void setJbTraziOdrediste(JButton jbTraziOdrediste) {
		OdredisteDialog.jbTraziOdrediste = jbTraziOdrediste;
	}

}
