package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.Node;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import view.CustomDialog;
import view.GuideDialog;
import view.InstalatorContent;
import view.MainFrame;

public class DodajButton implements ActionListener {	
	private static HashMap<String, String> preuzmi = new HashMap<String, String>();
	private static WritingProperties wp;
	public static HashMap<String, String> getPreuzmi() {
		return preuzmi;
	}
	public static void setPreuzmi(HashMap<String, String> preuzmi) {
		DodajButton.preuzmi = preuzmi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == MainFrame.getInstance().getJbDodajProizvod()) {
			
			if(MainFrame.getInstance().getTxtNazivProizvoda().getText().trim().length() != 0
			 && MainFrame.getInstance().getTxtVerzijaProizvoda().getText().trim().length() != 0) {
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				// a zatim i odgovarajuci cvor modela
				Node parentNodeModel = (Node)parentNodeView.getUserObject();
				
				// Kompanija ne sme biti dodata u proizvod
				if(parentNodeModel.getId()==0) {
					JOptionPane.showMessageDialog(null,
							MainFrame.getResourceBundle().getString("proizvod_mora_biit"),
							MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
				} else {
					// id = parentId + 1
					Node childNodeModel = new Node(MainFrame.getInstance().getTxtNazivProizvoda().getText(), parentNodeModel, parentNodeModel.getId()+1);
					// dodavanje cvora u model
					parentNodeModel.addChildren(childNodeModel);
					// kreiranje cvora koji ce biti prikazan u stablu 
					DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
					// dodavanje cvora koji ce biti prikazan u stablu
					DefaultTreeModel model = MainFrame.getInstance().getModel();
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					// selekcija novododatog cvora
					JTree tree = MainFrame.getInstance().getTree();
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
					// Dodavanje proizvoda u Node id = 2
					childNodeModel.setNaziv_proizvoda(MainFrame.getInstance().getTxtNazivProizvoda().getText());
					childNodeModel.setVerzija(MainFrame.getInstance().getTxtVerzijaProizvoda().getText());		
					childNodeModel.setOpis_proizvoda(MainFrame.getInstance().getTxtOpisProizvoda().getText());
					//childNodeModel.setLogo(MainFrame.getInstance().getPaneLogo());
				}		
				
				
				//System.out.println("dodaj proizvod");
			} else {
				JOptionPane.showMessageDialog(null,
						MainFrame.getResourceBundle().getString("morate_uneti_naziv_i_verziju"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			}
						
		} if(e.getSource() == MainFrame.getInstance().getJbDodajKompaniju()) {
			if(MainFrame.getInstance().getTxtNazKompanije().getText().trim().length() != 0) {
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				// a zatim i odgovarajuci cvor modela
				Node parentNodeModel = (Node)parentNodeView.getUserObject();
				
				// Kompanija ne sme biti dodata u proizvod
				if(parentNodeModel.getId()>0) {
					JOptionPane.showMessageDialog(null,
							MainFrame.getResourceBundle().getString("kompanija_ne_moze_biti_dodata"),
							MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
				} else {
					// id = parentId + 1
					Node childNodeModel = new Node(MainFrame.getInstance().getTxtNazKompanije().getText(), parentNodeModel, parentNodeModel.getId()+1);
					// dodavanje cvora u model
					parentNodeModel.addChildren(childNodeModel);
					// kreiranje cvora koji ce biti prikazan u stablu 
					DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
					// dodavanje cvora koji ce biti prikazan u stablu
					DefaultTreeModel model = MainFrame.getInstance().getModel();
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					// selekcija novododatog cvora
					JTree tree = MainFrame.getInstance().getTree();
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
					// Dodavanje kompanije, id = 1
					childNodeModel.setNaziv_kompanije(MainFrame.getInstance().getTxtNazKompanije().getText());
					childNodeModel.setSediste(MainFrame.getInstance().getTxtSediste().getText());
					childNodeModel.setPredstavnik(MainFrame.getInstance().getTxtPredstavnik().getText());
					
				}		
				
				
				
			} else {
				JOptionPane.showMessageDialog(null,
						MainFrame.getResourceBundle().getString("morate_uneti_naziv_kompanije"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			}
		}  if(e.getSource() == MainFrame.getInstance().getJbDodajParametar()) {
			if(MainFrame.getInstance().getTxtParametar().getText().trim().length()==0 ||
				MainFrame.getInstance().getTxtVrednostParametra().getText().trim().length() ==0) {
				JOptionPane.showMessageDialog(null,
						MainFrame.getResourceBundle().getString("parametar_mora_imati_naziv"),
						MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
			}else {
				
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				// a zatim i odgovarajuci cvor modela
				Node parentNodeModel = (Node)parentNodeView.getUserObject();
				
				// Kompanija ne sme biti dodata u proizvod
				if(parentNodeModel.getId()!=2) {
					JOptionPane.showMessageDialog(null,
							MainFrame.getResourceBundle().getString("parametar_mora_biti_deo_proizvoda"),
							MainFrame.getResourceBundle().getString("greska"), JOptionPane.ERROR_MESSAGE);
				} else {
					// id = parentId + 1
					Node childNodeModel = new Node(MainFrame.getInstance().getTxtParametar().getText(), parentNodeModel, parentNodeModel.getId()+1);
					// dodavanje cvora u model
					parentNodeModel.addChildren(childNodeModel);
					// kreiranje cvora koji ce biti prikazan u stablu 
					DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
					// dodavanje cvora koji ce biti prikazan u stablu
					DefaultTreeModel model = MainFrame.getInstance().getModel();
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					// selekcija novododatog cvora
					JTree tree = MainFrame.getInstance().getTree();
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
					// Dodavanje parametra
					childNodeModel.setNaziv_parametra(MainFrame.getInstance().getTxtParametar().getText());
					childNodeModel.setVrednost_parametra(MainFrame.getInstance().getTxtVrednostParametra().getText());
					
					SavingParameters.getVrednosti().put(MainFrame.getInstance().getTxtParametar().getText().toString(), MainFrame.getInstance().getTxtVrednostParametra().getText().toString());
					
					// provera da li se treba upisati cvor
					//if(CustomDialog.getCheckBoxTree().path)
					
					preuzmi.put(MainFrame.getInstance().getTxtParametar().getText().toString(),
							MainFrame.getInstance().getTxtVrednostParametra().getText().toString());
					
			}
			
		}
	}
		if(e.getSource() == MainFrame.getInstance().getJbDialog()) {
			CustomDialog cd = new CustomDialog();
			
			// hijerarhija	
			//WelcomeDialog welcomeDialog = new WelcomeDialog();
			//LicenceDialog licence = new LicenceDialog();
			//OdredisteDialog odr = new OdredisteDialog();
			//ZavrsenoDialog za = new ZavrsenoDialog();
			//GuideDialog gd = new GuideDialog();
		} if(e.getSource() == MainFrame.getInstance().getInstalator()) {
			GuideDialog gd = new GuideDialog();
		}
		
		if(e.getSource() == CustomDialog.getJbExportDialog()) {
			if(CustomDialog.getTxtWelcomeText().getText().toString().length() == 0 ||
			   CustomDialog.getTxtPutanja().getText().toString().length() == 0 ||
			   CustomDialog.getTxtLicence().getText().toString().length() == 0 ||
			   CustomDialog.getTxtVerzija().getText().toString().length() == 0) {
				JOptionPane.showMessageDialog(CustomDialog.getjDialogBox(),
					MainFrame.getResourceBundle().getString("svi_podaci"),
					MainFrame.getResourceBundle().getString("upozorenje"), JOptionPane.WARNING_MESSAGE);
		} else {
			
			
			/*
			 * Primenom ObjectOutputStream-a napraviti jednu datoteku setup.pbg sa nekom vašom ekstenzijom
			 * u kojoj će se metodom writeObject upisati sledeće:
			 *  Sadržaj properties datoteke (Properties klasa je serijalizabilna) 
			 *  Kompletan binarni sadržaj zip datoteke (izvor)
			 *  Welcome, licence i verzija 
			 * */
			
			// properties.ini
			try {
				System.out.println("Upisivanje properties.ini u setup.pbg");
				wp = new WritingProperties();
			} catch (Exception eeee) {
				// TODO Auto-generated catch block
				eeee.printStackTrace();
			}
			
			GuideDialog.setSource(CustomDialog.getTxtPutanja().getText().toString());
			
			InstalatorContent insta = new InstalatorContent(CustomDialog.getTxtWelcomeText().getText().toString(),
					CustomDialog.getTxtLicence().getText().toString(), CustomDialog.getTxtVerzija().getText().toString(),
					CustomDialog.getTxtPutanja().getText().toString());
			
			File fajl = new File("setup.pbg");
			ObjectOutputStream oos;
			try {				
				oos = new ObjectOutputStream(new FileOutputStream("setup.pbg"));
				oos.writeObject(insta);			// tekstualni podaci
				//oos.writeObject(wp); 			// properties.ini
				System.out.println("Upisano u datoteku: ");
				System.out.println(insta.getWelcomeText());
				System.out.println(insta.getLicence());
				System.out.println(insta.getVerzija());
				
				System.out.println("Upisana properties.ini datoteka");
				// upisivanje sadrzaja datoteke na lokaciji CustomDialog.getTxtPutanja().getText().toString()
				// upisivanje sadrzaja datoteke properties.ini
				
				// zatvaranje strima
				oos.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("FNF BUTTON EXCEPTION");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("DODAJ BUTTON EXCEPTION");
			}
			
			
			JOptionPane.showMessageDialog(CustomDialog.getjDialogBox(),
					MainFrame.getResourceBundle().getString("informacija"),
					MainFrame.getResourceBundle().getString("naslov_informacije"), JOptionPane.INFORMATION_MESSAGE);
			CustomDialog.getjDialogBox().dispose();
			CustomDialog.getjDialogBox().setVisible(false);
			
		}
	} if(e.getSource() == CustomDialog.getJbOdustaniDialog()) {
		CustomDialog.getjDialogBox().dispose();
		CustomDialog.getjDialogBox().setVisible(false);
	}
  }
}
