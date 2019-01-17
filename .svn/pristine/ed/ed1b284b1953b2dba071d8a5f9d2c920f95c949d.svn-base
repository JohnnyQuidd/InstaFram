package controllers;

import java.awt.CardLayout;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import view.MainFrame;

public class TreeListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTree().getLastSelectedPathComponent();
		
		if(parentNodeView==null) {
			return;
		}
		
		CardLayout c;
		
		Node parentNodeModel = (Node)parentNodeView.getUserObject();
		if(parentNodeModel.getId()==0) {
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "3");
		} else {
			c = MainFrame.getInstance().getC1();
			c.show(MainFrame.getInstance().getCardPanel(), "1");
		}
		
	}

}
