package controllers;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import view.MainFrame;

public class ListenForTextEntry implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == MainFrame.getInstance().getTxtNazivProizvoda()) {
			
			if(MainFrame.getInstance().getTxtNazivProizvoda().getText().trim().length() == 0) {
				MainFrame.getInstance().getTxtNazivProizvoda().setBackground(Color.red);
				JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("morate_uneti_naziv_proizvoda"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			} else if(MainFrame.getInstance().getTxtNazivProizvoda().getText().trim().length() != 0) {
				MainFrame.getInstance().getTxtNazivProizvoda().setBackground(Color.white);
			}
		} if(e.getSource() == MainFrame.getInstance().getTxtVerzijaProizvoda()) {
			
			if(MainFrame.getInstance().getTxtVerzijaProizvoda().getText().trim().length() == 0) {
				MainFrame.getInstance().getTxtVerzijaProizvoda().setBackground(Color.red);
				JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("morate_uneti_verziju_proizvoda"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			} if(MainFrame.getInstance().getTxtVerzijaProizvoda().getText().trim().length() != 0) {
				MainFrame.getInstance().getTxtVerzijaProizvoda().setBackground(Color.white);
			}
		} if(e.getSource() == MainFrame.getInstance().getTxtOpisProizvoda()) {
			if(MainFrame.getInstance().getTxtOpisProizvoda().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtOpisProizvoda().setBackground(Color.gray);
				MainFrame.getInstance().getTxtOpisProizvoda().setText(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_opis_proizvoda"));
			}if(MainFrame.getInstance().getTxtOpisProizvoda().getText().trim().length() != 0 && 
					!MainFrame.getInstance().getTxtOpisProizvoda().getText().trim().equals(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_opis_proizvoda")) ) {
				MainFrame.getInstance().getTxtOpisProizvoda().setBackground(Color.white);
			}
		} if(e.getSource() == MainFrame.getInstance().getTxtNazKompanije()) {
			if(MainFrame.getInstance().getTxtNazKompanije().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtNazKompanije().setBackground(Color.red);
				JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("morate_uneti_naziv_kompanije"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			} if(MainFrame.getInstance().getTxtNazKompanije().getText().trim().length()!=0) {
				MainFrame.getInstance().getTxtNazKompanije().setBackground(Color.white);
			}
			
		} if(e.getSource() == MainFrame.getInstance().getTxtPredstavnik()) {
			if(MainFrame.getInstance().getTxtPredstavnik().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtPredstavnik().setBackground(Color.gray);
				MainFrame.getInstance().getTxtPredstavnik().setText(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_ime_predstavnika"));
			} if(MainFrame.getInstance().getTxtPredstavnik().getText().trim().length()!=0
					&& !MainFrame.getInstance().getTxtPredstavnik().getText().trim().equals(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_ime_predstavnika")) ) {
				MainFrame.getInstance().getTxtPredstavnik().setBackground(Color.white);
			}		
		} if(e.getSource() == MainFrame.getInstance().getTxtSediste()) {
			if(MainFrame.getInstance().getTxtSediste().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtSediste().setBackground(Color.gray);
				MainFrame.getInstance().getTxtSediste().setText(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_sediste_kompanije"));
			} if(MainFrame.getInstance().getTxtSediste().getText().trim().length()!=0
					&& !MainFrame.getInstance().getTxtSediste().getText().trim().equals(MainFrame.getResourceBundle().getString("pozeljno_je_uneti_sediste_kompanije")) ) {
				MainFrame.getInstance().getTxtSediste().setBackground(Color.white);
			}		
		} if(e.getSource() == MainFrame.getInstance().getTxtParametar()) {
			if(MainFrame.getInstance().getTxtParametar().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtParametar().setBackground(Color.red);
				JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("morate_uneti_naziv_parametra"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			} if(MainFrame.getInstance().getTxtParametar().getText().trim().length()!=0) {
				MainFrame.getInstance().getTxtParametar().setBackground(Color.white);
			}
		} if(e.getSource() == MainFrame.getInstance().getTxtVrednostParametra()) {
			if(MainFrame.getInstance().getTxtVrednostParametra().getText().trim().length()==0) {
				MainFrame.getInstance().getTxtVrednostParametra().setBackground(Color.red);
				JOptionPane.showMessageDialog(null, MainFrame.getResourceBundle().getString("morate_uneti_vrednost_parametra"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			} if(MainFrame.getInstance().getTxtVrednostParametra().getText().trim().length()!=0) {
				MainFrame.getInstance().getTxtVrednostParametra().setBackground(Color.white);
			}
		}
					
		
	}
}
