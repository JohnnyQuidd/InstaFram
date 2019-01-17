package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ZavrsenoDialog {
	
	public static JDialog dialogZavrseno = new JDialog(OdredisteDialog.getDialogOdrediste());
	public static JButton jbKraj;
	public JTextArea txtIspis;

	public ZavrsenoDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		dialogZavrseno.setSize(screenWidth/2, screenHeight/2);
		dialogZavrseno.setTitle("Excel 1.0.0");
		dialogZavrseno.setLocationRelativeTo(null);
		
		jbKraj = new JButton("Kraj");
		JPanel centerPanelZav = new JPanel();
		JPanel lowerPanelZav = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel glavniPanelZav = new JPanel(new BorderLayout());
		
		String ispis = new String("Softverski proizvod uspesno instaliran");
		txtIspis = new JTextArea(ispis, 100,80);
		centerPanelZav.add(txtIspis);
		lowerPanelZav.add(jbKraj);
		
		glavniPanelZav.add(centerPanelZav, BorderLayout.CENTER);
		glavniPanelZav.add(lowerPanelZav, BorderLayout.SOUTH);
		
		dialogZavrseno.add(glavniPanelZav);
		dialogZavrseno.setVisible(true);
		
	}
	public static JDialog getDialogZavrseno() {
		return dialogZavrseno;
	}

	public static void setDialogZavrseno(JDialog dialogZavrseno) {
		ZavrsenoDialog.dialogZavrseno = dialogZavrseno;
	}

	public static JButton getJbKraj() {
		return jbKraj;
	}

	public static void setJbKraj(JButton jbKraj) {
		ZavrsenoDialog.jbKraj = jbKraj;
	}
}
