package controllers;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.Node;
import view.MainFrame;
public class AddNodeAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5219475554650492727L;
	private static int incrementer;

	/**
	 * 
	 */
	public AddNodeAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	
	//Ovde treba nekako uz ime da se prosledi ID, kao apendovano ime
	public AddNodeAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param icon
	 */
	public AddNodeAction(String name, Icon icon) {
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
		// preuzecemo selektovani cvor u stablu
		// Ovde pravi distinkciju izmedju komponenti
		DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTree().getLastSelectedPathComponent();
		// nema sta da se dodaje
		if (parentNodeView == null) {
			return;
		}
		// a zatim i odgovarajuci cvor modela
		Node parentNodeModel = (Node)parentNodeView.getUserObject();
		// kreiranje detata koji je cvor modela
		
		// id = parentId + 1
		Node childNodeModel = new Node(MainFrame.getInstance().getTextField(), parentNodeModel, parentNodeModel.getId()+1);
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
		//System.out.println("Cvor: " + childNodeModel.getName() + " ID: " + childNodeModel.getId() + " \n");
		

	}

}