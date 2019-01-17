package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import view.MainFrame;

public class ChangeValues implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == MainFrame.getInstance().getJbApply()) {
			DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTree().getLastSelectedPathComponent();
			// nema sta da se dodaje
			if (parentNodeView == null) {
				return;
			}
			// a zatim i odgovarajuci cvor modela
			Node parentNodeModel = (Node)parentNodeView.getUserObject();
			
			// Zavisno od id-a menjamo parametre
			if(parentNodeModel.getId() == 1) {
				// Kompanija
				parentNodeModel.setNaziv_kompanije(MainFrame.getInstance().getTxtNazKompanije().getText());
				parentNodeModel.setSediste(MainFrame.getInstance().getTxtSediste().getText());
				parentNodeModel.setPredstavnik(MainFrame.getInstance().getTxtPredstavnik().getText());
				
			} if(parentNodeModel.getId() == 2) {
				// Proizvod
				parentNodeModel.setNaziv_proizvoda(MainFrame.getInstance().getTxtNazivProizvoda().getText());
				parentNodeModel.setVerzija(MainFrame.getInstance().getTxtVerzijaProizvoda().getText());
				parentNodeModel.setOpis_proizvoda(MainFrame.getInstance().getTxtOpisProizvoda().getText());
				//parentNodeModel.setLogo(MainFrame.getInstance().getPaneLogo());
				
			} if(parentNodeModel.getId() >= 3) {
				// Parametar
				parentNodeModel.setNaziv_parametra(MainFrame.getInstance().getTxtParametar().getText());
				parentNodeModel.setVrednost_parametra(MainFrame.getInstance().getTxtVrednostParametra().getText());
			}
		}
	}

}
