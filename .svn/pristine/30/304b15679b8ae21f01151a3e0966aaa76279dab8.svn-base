package controllers;

import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import view.MainFrame;

public class SearchNodeAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5049032247689190336L;

	/**
	 * 
	 */
	public SearchNodeAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public SearchNodeAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param icon
	 */
	public SearchNodeAction(String name, Icon icon) {
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
		String se = JOptionPane.showInputDialog(MainFrame.getInstance(), "");
		if (se == null) {
			return;
		}

		DefaultTreeModel model = MainFrame.getInstance().getModel();

		// Iteracija kroz stablo, spustanje nivo po nivo
		@SuppressWarnings("unchecked")
		Enumeration<TreeNode> en = ((DefaultMutableTreeNode) model
				.getRoot()).breadthFirstEnumeration();

		boolean found = false;
		while (en.hasMoreElements()) {
			DefaultMutableTreeNode curr = (DefaultMutableTreeNode) en.nextElement();
			if (curr.getUserObject().toString().equalsIgnoreCase(se)) {
				// Selektuj nadjeni cvor i prikazi ga korisniku
				MainFrame.getInstance().getTree()
						.setSelectionPath(new TreePath(curr.getPath()));
				MainFrame.getInstance().getTree()
						.scrollPathToVisible(new TreePath(curr.getPath()));
				found = true;
				break;
			}
		}

		if (!found) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),
					MainFrame.getResourceBundle().getString("nema_pronadjenih"), MainFrame.getResourceBundle().getString("greska"), JOptionPane.WARNING_MESSAGE);

		}

	}

}
