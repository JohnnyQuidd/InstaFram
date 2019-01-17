package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.DialogManipulation;
import controllers.FileOpener;

public class GuideDialog {
	public static JDialog jDialogWelcome;
	public static JTextArea txtWelcome;
	public static JButton jbOdustaniWelcome, jbSledeceWelcome;
	public static JDialog dialogLicence;
	public static JButton jbOdustaniLicence, jbPrethodnoLicence, jbSledeceLicence;
	public static JCheckBox jbAgreeLicence;
	public static JLabel lblOdrediste;
	public static JTextField txtOdrediste;
	public static JButton jbOdustaniOdrediste, jbPrethodnoOdrediste, jbSledeceOdrediste, jbTraziOdrediste;
	public static JDialog dialogZavrseno;
	public static JButton jbKraj;
	public static JTextArea txtIspisKraj;
	private static JFrame guideFrame;
	public static JDialog jdGuideDialog = new JDialog(guideFrame);
	public static CardLayout c1;
	public static JPanel guidePanel;
	private static String source;
	
	public static String tekstDobrodoslice, tekstLicence, brojVerzije, apsolutnaPutanja;

	public GuideDialog(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		// citanje u GuideDialog komponente
		
		ObjectInputStream ois;
		InstalatorContent instaLoad;
		try {
			// Citanje upisanog objekta i uzimanje vrednosti
			ois = new ObjectInputStream(new FileInputStream("setup.pbg"));
			instaLoad = (InstalatorContent) ois.readObject();
			 
			System.out.println("Citanje iz fajla setup.pbg");
			System.out.println(instaLoad.getWelcomeText());
			System.out.println(instaLoad.getLicence());
			System.out.println(instaLoad.getVerzija());
						 
			tekstDobrodoslice = (instaLoad.getWelcomeText());
			tekstLicence = (instaLoad.getLicence());
			brojVerzije = (instaLoad.getVerzija());
			source = (instaLoad.getIzvor());
					 
			 ois.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		guideFrame = new JFrame();
		
		guideFrame.setSize(960, 540);
		guideFrame.setTitle("InstaFram " + brojVerzije);
		guideFrame.setLocationRelativeTo(null);
		
//		jdGuideDialog.setSize(960, 540);
//		jdGuideDialog.setTitle("InstaFram " + brojVerzije);
//		jdGuideDialog.setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		txtWelcome = new JTextArea(tekstDobrodoslice,17,58);
		txtWelcome.setEditable(false);
		txtWelcome.setFont(new Font("SansSerif Plain", Font.PLAIN, 20));
		txtWelcome.setOpaque(false);
		txtWelcome.setBackground(new Color(0, 0, 0, 0));
		
		
		JScrollPane scrollPane = new JScrollPane(txtWelcome);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		jbOdustaniWelcome = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		jbOdustaniWelcome.addActionListener(new DialogManipulation());
		
		jbSledeceWelcome = new JButton(MainFrame.getResourceBundle().getString("sledece"));
		jbSledeceWelcome.addActionListener(new DialogManipulation());
		
		panel.add(jbOdustaniWelcome);
		panel.add(jbSledeceWelcome);
		
		// U CARD LAYOUT TREBA DODATI panel->1, mainPanel->3, licencePanel->2, glavniPanelZav->4
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel upperPanel = new JPanel();
		upperPanel.setPreferredSize(new Dimension(10,150));
		JPanel centerPanel = new JPanel(new FlowLayout());
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		jbOdustaniOdrediste = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		jbOdustaniOdrediste.addActionListener(new DialogManipulation());
		jbPrethodnoOdrediste = new JButton(MainFrame.getResourceBundle().getString("prethodno"));
		jbPrethodnoOdrediste.addActionListener(new DialogManipulation());
		jbSledeceOdrediste = new JButton(MainFrame.getResourceBundle().getString("sledece"));
		jbSledeceOdrediste.addActionListener(new DialogManipulation());
		jbTraziOdrediste = new JButton("...");
		jbTraziOdrediste.addActionListener(new FileOpener());
		//jbTraziOdrediste.setToolTipText(MainFrame.getResourceBundle().getString("odabir_lokacije"));
		
		
		
		lblOdrediste = new JLabel(MainFrame.getResourceBundle().getString("odrediste"));
		lblOdrediste.setFont(new Font("SansSerif Plain", Font.PLAIN, 15));
		txtOdrediste = new JTextField("", 30);
		
		centerPanel.add(lblOdrediste);
		centerPanel.add(txtOdrediste);
		centerPanel.add(jbTraziOdrediste);
		
		mainPanel.add(upperPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		lowerPanel.add(jbOdustaniOdrediste);
		lowerPanel.add(jbPrethodnoOdrediste);
		lowerPanel.add(jbSledeceOdrediste);
		
		
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		
		// Licence 
		JPanel licencePanel = new JPanel(new BorderLayout());
		JTextArea txtLicence = new JTextArea(tekstLicence,15,55);
		txtLicence.setEditable(false);
		txtLicence.setFont(new Font("SansSerif Plain", Font.PLAIN, 20));	
		txtLicence.setOpaque(false);
		txtLicence.setBackground(new Color(0,0,0));
		
		JScrollPane scroll = new JScrollPane(txtLicence);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		
		licencePanel.add(scroll, BorderLayout.NORTH);
		
		jbAgreeLicence = new JCheckBox(MainFrame.getResourceBundle().getString("saglasnost"));
		jbAgreeLicence.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		jbAgreeLicence.addActionListener(new DialogManipulation());
		
		jbOdustaniLicence = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		jbOdustaniLicence.addActionListener(new DialogManipulation());
		
		jbPrethodnoLicence = new JButton(MainFrame.getResourceBundle().getString("prethodno"));
		jbPrethodnoLicence.addActionListener(new DialogManipulation());
		
		jbSledeceLicence = new JButton(MainFrame.getResourceBundle().getString("sledece"));
		jbSledeceLicence.addActionListener(new DialogManipulation());			
		
		JPanel lowerPanelLicence = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel centerPanelLicence = new JPanel();
		
		licencePanel.add(jbAgreeLicence, BorderLayout.CENTER);
		lowerPanelLicence.add(jbOdustaniLicence);
		lowerPanelLicence.add(jbPrethodnoLicence);
		lowerPanelLicence.add(jbSledeceLicence);
		
		licencePanel.add(lowerPanelLicence, BorderLayout.SOUTH);
		//licencePanel.add(centerPanelLicence);			// DODAO NA SVOJU RUKU
		
		// Zavrsni panel
		jbKraj = new JButton(MainFrame.getResourceBundle().getString("kraj"));
		jbKraj.addActionListener(new DialogManipulation());
		JPanel centerPanelZav = new JPanel();
		JPanel lowerPanelZav = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		JPanel glavniPanelZav = new JPanel(new BorderLayout());
		
		String ispis = new String("Uspesno Instalirano");
		txtIspisKraj = new JTextArea(ispis, 17,55);
		txtIspisKraj.setEditable(false);
		txtIspisKraj.setFont(new Font("SansSerif Plain", Font.PLAIN, 20));
		txtIspisKraj.setOpaque(false);
		txtIspisKraj.setBackground(new Color(0,0,0));
		
		JScrollPane skp = new JScrollPane(txtIspisKraj);
		skp.getViewport().setOpaque(false);
		skp.setOpaque(false);
		skp.setBorder(BorderFactory.createEmptyBorder());
		
		centerPanelZav.add(skp);
		lowerPanelZav.add(jbKraj);
		
		glavniPanelZav.add(centerPanelZav, BorderLayout.CENTER);
		glavniPanelZav.add(lowerPanelZav, BorderLayout.SOUTH);
		
		// Sklapanje
		guidePanel = new JPanel();
		c1 = new CardLayout();
		guidePanel.setLayout(c1);
		guidePanel.add(panel, "1");
		guidePanel.add(licencePanel, "2");
		guidePanel.add(mainPanel, "3");
		guidePanel.add(glavniPanelZav, "4");
		
		c1.show(guidePanel, "1");
		
		
			
		
		ImageIcon img = new ImageIcon("images/instaframNew.png");
		guideFrame.setIconImage(img.getImage());
		guideFrame.add(guidePanel);
		guideFrame.setVisible(true);
		
	}
	
	public static String getSource() {
		return source;
	}

	public static void setSource(String source) {
		GuideDialog.source = source;
	}
	
	
	public static JFrame getGuideFrame() {
		return guideFrame;
	}
	public static void setGuideFrame(JFrame guideFrame) {
		GuideDialog.guideFrame = guideFrame;
	}

	public static String getTekstDobrodoslice() {
		return tekstDobrodoslice;
	}

	public static void setTekstDobrodoslice(String tekstDobrodoslice) {
		GuideDialog.tekstDobrodoslice = tekstDobrodoslice;
	}
	
	public static JPanel getGuidePanel() {
		return guidePanel;
	}

	public static void setGuidePanel(JPanel ki) {
		GuideDialog.guidePanel = ki;
	}
	
	public static CardLayout getC1() {
		return c1;
	}

	public static void setC1(CardLayout k) {
		GuideDialog.c1 = k;
	}
	
	public static JDialog getGuideDialog() {
		return jdGuideDialog;
	}

	public static void setGuideDialog(JDialog gd) {
		GuideDialog.jdGuideDialog = gd;
	}
	
	public static JDialog getjDialogWelcome() {
		return jDialogWelcome;
	}
	public static void setjDialogWelcome(JDialog kk) {
		GuideDialog.jDialogWelcome = kk;
	}
	public static JTextArea getTxtWelcome() {
		return txtWelcome;
	}
	public static void setTxtWelcome(JTextArea txt) {
		GuideDialog.txtWelcome = txt;
	}
	public static JButton getJbOdustaniWelcome() {
		return jbOdustaniWelcome;
	}
	public static void setJbOdustaniWelcome(JButton ow) {
		GuideDialog.jbOdustaniWelcome = ow;
	}
	public static JButton getJbSledeceWelcome() {
		return jbSledeceWelcome;
	}
	public static void setJbSledeceWelcome(JButton sw) {
		GuideDialog.jbSledeceWelcome = sw;
	}
	public static JDialog getDialogLicence() {
		return dialogLicence;
	}
	public static void setDialogLicence(JDialog dl) {
		GuideDialog.dialogLicence = dl;
	}
	public static JButton getJbOdustaniLicence() {
		return jbOdustaniLicence;
	}
	public static void setJbOdustaniLicence(JButton ty) {
		GuideDialog.jbOdustaniLicence = ty;
	}
	public static JButton getJbPrethodnoLicence() {
		return jbPrethodnoLicence;
	}
	public static void setJbPrethodnoLicence(JButton pl) {
		GuideDialog.jbPrethodnoLicence = pl;
	}
	public static JButton getJbSledeceLicence() {
		return jbSledeceLicence;
	}
	public static void setJbSledeceLicence(JButton ks) {
		GuideDialog.jbSledeceLicence = ks;
	}
	public static JCheckBox getJbAgreeLicence() {
		return jbAgreeLicence;
	}
	public static void setJbAgreeLicence(JCheckBox al) {
		GuideDialog.jbAgreeLicence = al;
	}
	public JLabel getLblOdrediste() {
		return lblOdrediste;
	}
	public void setLblOdrediste(JLabel lblOdrediste) {
		GuideDialog.lblOdrediste = lblOdrediste;
	}
	public static JTextField getTxtOdrediste() {
		return txtOdrediste;
	}
	public static void setTxtOdrediste(String str) {
		GuideDialog.txtOdrediste.setText(str);
	}
	public static JButton getJbOdustaniOdrediste() {
		return jbOdustaniOdrediste;
	}
	public static void setJbOdustaniOdrediste(JButton od) {
		GuideDialog.jbOdustaniOdrediste = od;
	}
	public static JButton getJbPrethodnoOdrediste() {
		return jbPrethodnoOdrediste;
	}
	public static void setJbPrethodnoOdrediste(JButton po) {
		GuideDialog.jbPrethodnoOdrediste = po;
	}
	public static JButton getJbSledeceOdrediste() {
		return jbSledeceOdrediste;
	}
	public static void setJbSledeceOdrediste(JButton so) {
		GuideDialog.jbSledeceOdrediste = so;
	}
	public static JButton getJbTraziOdrediste() {
		return jbTraziOdrediste;
	}
	public static void setJbTraziOdrediste(JButton tr) {
		GuideDialog.jbTraziOdrediste = tr;
	}
	public static JDialog getDialogZavrseno() {
		return dialogZavrseno;
	}
	public static void setDialogZavrseno(JDialog dz) {
		GuideDialog.dialogZavrseno = dz;
	}
	public static JButton getJbKraj() {
		return jbKraj;
	}
	public static void setJbKraj(JButton kr) {
		GuideDialog.jbKraj = kr;
	}
	public static JTextArea getTxtIspisKraj() {
		return txtIspisKraj;
	}
	public static void setTxtIspisKraj(JTextArea txtIspisKraj) {
		GuideDialog.txtIspisKraj = txtIspisKraj;
	}
	
	public static String getTekstLicence() {
		return tekstLicence;
	}

	public static void setTekstLicence(String tekstLicence) {
		GuideDialog.tekstLicence = tekstLicence;
	}

	public static String getBrojVerzije() {
		return brojVerzije;
	}

	public static void setBrojVerzije(String brojVerzije) {
		GuideDialog.brojVerzije = brojVerzije;
	}

	public static String getApsolutnaPutanja() {
		return apsolutnaPutanja;
	}

	public static void setApsolutnaPutanja(String apsolutnaPutanja) {
		GuideDialog.apsolutnaPutanja = apsolutnaPutanja;
	}
	
}
