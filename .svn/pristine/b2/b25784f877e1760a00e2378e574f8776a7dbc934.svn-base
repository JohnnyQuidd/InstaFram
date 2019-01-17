package controllers;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import view.MainFrame;

public class RemoveNodeAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5355845432248553679L;

	/**
	 * 
	 */
	public RemoveNodeAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public RemoveNodeAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param icon
	 */
	public RemoveNodeAction(String name, Icon icon) {
		super(name, icon);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Vrlo vazno: Ovako se nalazi koji je Node selektovan
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		// preuzimamo cvor modela koji odgovara selektovanom cvoru
		Node childNodeModel = (Node) childNodeView.getUserObject();
		// ne mozemo obrisati koren stabla
		if (childNodeModel.isRoot()) {
			return;
		}
		// uklanjamo cvor iz modela
		childNodeModel.removeFromParent();
		// uklanjemo cvor iz prikaza
		MainFrame.getInstance().getModel().removeNodeFromParent(childNodeView);
		
	}

}
