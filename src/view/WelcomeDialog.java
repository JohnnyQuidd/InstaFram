package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.DialogManipulation;

public class WelcomeDialog {
	
	public static JDialog jDialogWelcome;
	public JTextArea txtWelcome;
	public static JButton jbOdustani, jbSledece;

	public WelcomeDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		jDialogWelcome = new JDialog(MainFrame.getInstance());
		
		jDialogWelcome.setSize(screenWidth/2, screenHeight/2);
		jDialogWelcome.setTitle("Excel 1.0.0");
		//jDialogWelcome.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		jDialogWelcome.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		txtWelcome = new JTextArea("Dobro dosli u instalaciju\nsoftverskog proizvoda Excel.", 20, 60);
		txtWelcome.setOpaque(false);
		txtWelcome.setBackground(new Color(0, 0, 0, 0));
		
		
		JScrollPane scrollPane = new JScrollPane(txtWelcome);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		panel.add(scrollPane, BorderLayout.CENTER);
		jDialogWelcome.add(panel);
		
		jbOdustani = new JButton("Odustani");
		jbOdustani.addActionListener(new DialogManipulation());
		
		jbSledece = new JButton("Sledece");
		jbSledece.addActionListener(new DialogManipulation());
		
		panel.add(jbOdustani);
		panel.add(jbSledece);
		
		
		
		jDialogWelcome.setVisible(true);
	}
	
	public WelcomeDialog(JDialog parent) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		jDialogWelcome = new JDialog(parent);
		
		jDialogWelcome.setSize(screenWidth/2, screenHeight/2);
		jDialogWelcome.setTitle("Excel 1.0.0");
		//jDialogWelcome.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		jDialogWelcome.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		txtWelcome = new JTextArea("Dobro dosli u instalaciju\nsoftverskog proizvoda Excel.", 20, 60);
		txtWelcome.setOpaque(false);
		txtWelcome.setBackground(new Color(0, 0, 0, 0));
		
		
		JScrollPane scrollPane = new JScrollPane(txtWelcome);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		panel.add(scrollPane, BorderLayout.CENTER);
		jDialogWelcome.add(panel);
		
		jbOdustani = new JButton("Odustani");
		jbOdustani.addActionListener(new DialogManipulation());
		
		jbSledece = new JButton("Sledece");
		jbSledece.addActionListener(new DialogManipulation());
		
		panel.add(jbOdustani);
		panel.add(jbSledece);
		
		
		
		jDialogWelcome.setVisible(true);
	}
	
	public static JButton getJbOdustani() {
		return jbOdustani;
	}

	public static void setJbOdustani(JButton jbOdustani) {
		WelcomeDialog.jbOdustani = jbOdustani;
	}

	public static JButton getJbSledece() {
		return jbSledece;
	}

	public static void setJbSledece(JButton jbSledece) {
		WelcomeDialog.jbSledece = jbSledece;
	}
	public static JDialog getWelcomeDialog() {
		return jDialogWelcome;
	}
}
