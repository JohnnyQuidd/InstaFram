package view.tree;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Node;

public class NodeTreeCellRendered extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652394700428406234L;
	
	public NodeTreeCellRendered() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {
			// ocekujemo DefaultMutableTreeNode
			// iz koga preuzimamo node
			Node node = (Node) ((DefaultMutableTreeNode) value).getUserObject();
			// do ovoga ne bi trebalo da dodje, ako je stablo pazljivo kreirano
			if (node == null) {
				return this;
			}
			// na jedan nacin iscrtavamo cvor stabla koji ima decu
			// a na drugi nacin cvor modela koji je list
			String iconPath = node.isRoot() ? "images/workspaceNew.png"
					: (node.isLeaf() ? "images/parameterNew.png" : "images/companyNew.png");

			
			String text = node.getName();
			
			
			setIcon(new ImageIcon(iconPath));
			if(node.isRoot()) {
				setText("Workspace");
				node.setId(0);
			} else {
				setText(text);
			}

			// ukoliko bismo imali cvorove u stablu modela koji pripadaju
			// razlicitim klasama, tada bismo radili sledece
//            	if (value instanceof Klasa1) {
//            		setIcon(new ImageIcon("images/klasa1.png"));	
//            	} else if (value instanceof Klasa2) {
//            		setIcon(new ImageIcon("images/klasa2.png"));
//            	} else if (value instanceof Klasa3) {
//            		setIcon(new ImageIcon("images/klasa3.png"));
//            	}

		}

		return this;
	}

}
