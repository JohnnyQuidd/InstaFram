package controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import view.MainFrame;

public class ListenForSwitchButton implements  ActionListener{
	CardLayout c;
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// TODO Auto-generated method stub
		if (e.getSource() == MainFrame.getInstance().getJbKompanija()) {
			
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "3");
			
		} if(e.getSource() == MainFrame.getInstance().getJbSwitch()) {
			
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "2");
			
		} if(e.getSource() == MainFrame.getInstance().getjbProizvod()) {
			
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "1");
			
		} if(e.getSource() == MainFrame.getInstance().getJbParametar()) {
			
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "4");
			
		} if(e.getSource() == MainFrame.getInstance().getBtnEdit()) {
			// U zavisnosti od tipa cvora otvara jednu od 3 parspektive
			DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTree().getLastSelectedPathComponent();
			
			if (parentNodeView == null) {
				return;
			}
			
			Node parentNodeModel = (Node)parentNodeView.getUserObject();
			
			if(parentNodeModel.getId() == 1) {
				// Kompanija
				c = MainFrame.getInstance().getC1();
				c.show(MainFrame.getInstance().getCardPanel(), "3");
				
				// Popunjavanje vrednosti
				MainFrame.getInstance().getTxtNazKompanije().setText(parentNodeModel.getNaziv_kompanije());
				MainFrame.getInstance().getTxtSediste().setText(parentNodeModel.getSediste());
				MainFrame.getInstance().getTxtPredstavnik().setText(parentNodeModel.getPredstavnik());
				
			} if (parentNodeModel.getId() == 2) {
				// Proizvod
				c = MainFrame.getInstance().getC1();
				c.show(MainFrame.getInstance().getCardPanel(), "1");
				
				// Popunjavanje proizvoda
				MainFrame.getInstance().getTxtNazivProizvoda().setText(parentNodeModel.getNaziv_proizvoda());
				MainFrame.getInstance().getTxtVerzijaProizvoda().setText(parentNodeModel.getVerzija());
				MainFrame.getInstance().getTxtOpisProizvoda().setText(parentNodeModel.getOpis_proizvoda());
				//MainFrame.getInstance().getPaneLogo().add(parentNodeModel.getLogo());
			} if(parentNodeModel.getId() >= 3) {
				// Parametar
				c = MainFrame.getInstance().getC1();
				c.show(MainFrame.getInstance().getCardPanel(), "4");
				
				// Popunjavanje parametra
				MainFrame.getInstance().getTxtParametar().setText(parentNodeModel.getNaziv_parametra());
				MainFrame.getInstance().getTxtVrednostParametra().setText(parentNodeModel.getVrednost_parametra());
			}
		}
	}

}
