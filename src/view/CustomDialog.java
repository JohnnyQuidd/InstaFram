package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import controllers.DodajButton;
import controllers.FileOpener;
import controllers.TreeListener;
import model.Node;
import net.miginfocom.swing.MigLayout;
import view.tree.CellEditor;
import view.tree.NodeTreeCellRendered;

public class CustomDialog {
 
	
	public static JButton jbTraziPutanju;
	public static JTextArea txtWelcomeText, txtLicence;
	public JLabel lblIzvor, lblWelcomeText, lblLicence, lblVerzija;
	public static JDialog jDialogBox = new JDialog(MainFrame.getInstance());
	public static JTextField txtPutanja;
	public static JTextField txtVerzija;
	public static JButton jbExportDialog;
	public static JButton jbOdustaniDialog;
	public JTree tree;
	public static JCheckBoxTree checkBoxTree;
	

	public Node rootOfOurModel;
	public DefaultTreeModel treeModel;
	
	
	public CustomDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		
		jDialogBox.setSize(960, 540);		
		jDialogBox.setLocationRelativeTo(null);
		jDialogBox.setVisible(true);
		jDialogBox.setTitle(MainFrame.getResourceBundle().getString("konfigurator_proizvoda"));
		
		// Upper panel ostaje prazan
		JPanel upperPanel = new JPanel();
		upperPanel.setPreferredSize(new Dimension(50,40));
		
		// LowerPanel mora imati Export i Odustani 
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		lowerPanel.setPreferredSize(new Dimension(50,40));
		jbExportDialog = new JButton(MainFrame.getResourceBundle().getString("eksportuj"));
		jbExportDialog.addActionListener(new DodajButton());
		jbOdustaniDialog = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		jbOdustaniDialog.addActionListener(new DodajButton());
		
		lowerPanel.add(jbExportDialog);
		lowerPanel.add(jbOdustaniDialog);
		
		
		// WestPanel sadrzi stablo
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(300,40));
		westPanel.setMinimumSize(new Dimension(100,40));
		
		
//		tree = new JTree();
//		initTree();
//		tree.setModel(MainFrame.getInstance().getTreeModel());
		
		checkBoxTree = new JCheckBoxTree();
		//initCheckBoxTree();
		checkBoxTree.setModel(MainFrame.getInstance().getTreeModel());
		
		
		
		// Komponenta u koju se smesta stablo
		JScrollPane jsTreeHolder = new JScrollPane(checkBoxTree, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsTreeHolder.setPreferredSize(new Dimension(300,screenHeight/2 - 115));
		jsTreeHolder.setMinimumSize(new Dimension(100, screenHeight/2 - 115));
		
		westPanel.add(jsTreeHolder);
		
		// Sve ostalo ide u najveci, centerPanel
		JPanel centerPanel = new JPanel(new MigLayout("","[][]10[]", "[]10[]"));
		
		lblIzvor = new JLabel(MainFrame.getResourceBundle().getString("izvor_zip"));
		txtPutanja = new JTextField("", 50);
		jbTraziPutanju = new JButton("...");
		jbTraziPutanju.addActionListener(new FileOpener());
		
		lblWelcomeText = new JLabel(MainFrame.getResourceBundle().getString("tekst_dobrodoslice"));
		txtWelcomeText = new JTextArea("", 7, 50);
		txtWelcomeText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		lblLicence = new JLabel(MainFrame.getResourceBundle().getString("licenca"));
		txtLicence = new JTextArea("", 7, 50);
		txtLicence.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		lblVerzija = new JLabel(MainFrame.getResourceBundle().getString("verzija"));
		txtVerzija = new JTextField("", 50);
		
		// kolona | red
		centerPanel.add(lblIzvor, "cell 0 0");
		centerPanel.add(txtPutanja, "cell 1 0");
		centerPanel.add(jbTraziPutanju, "cell 2 0, wrap");
		centerPanel.add(lblWelcomeText, "cell 0 1");
		centerPanel.add(txtWelcomeText, "cell 1 1, wrap");
		centerPanel.add(lblLicence, "cell 0 2");
		centerPanel.add(txtLicence, "cell 1 2, wrap");
		centerPanel.add(lblVerzija, "cell 0 3");
		centerPanel.add(txtVerzija, "cell 1 3, wrap");
		
		
		
		jDialogBox.add(upperPanel, BorderLayout.NORTH);
		jDialogBox.add(lowerPanel, BorderLayout.SOUTH);
		jDialogBox.add(westPanel, BorderLayout.WEST);
		jDialogBox.add(centerPanel, BorderLayout.CENTER);
		
		
		jDialogBox.setVisible(true);
		
		
		
	}
	
	public static JCheckBoxTree getCheckBoxTree() {
		return checkBoxTree;
	}

	public static void setCheckBoxTree(JCheckBoxTree checkBoxTree) {
		CustomDialog.checkBoxTree = checkBoxTree;
	}
	
	public static JTextArea getTxtWelcomeText() {
		return txtWelcomeText;
	}

	public static void setTxtWelcomeText(JTextArea txtWelcomeText) {
		CustomDialog.txtWelcomeText = txtWelcomeText;
	}

	public static JTextArea getTxtLicence() {
		return txtLicence;
	}

	public static void setTxtLicence(JTextArea txtLicence) {
		CustomDialog.txtLicence = txtLicence;
	}

	public static JDialog getjDialogBox() {
		return jDialogBox;
	}

	public static void setjDialogBox(JDialog jDialogBox) {
		CustomDialog.jDialogBox = jDialogBox;
	}

	public static JButton getJbExportDialog() {
		return jbExportDialog;
	}

	public static void setJbExportDialog(JButton jbExportDialog) {
		CustomDialog.jbExportDialog = jbExportDialog;
	}

	public static JButton getJbOdustaniDialog() {
		return jbOdustaniDialog;
	}

	public static void setJbOdustaniDialog(JButton jbOdustaniDialog) {
		CustomDialog.jbOdustaniDialog = jbOdustaniDialog;
	}

	public static JTextField getTxtVerzija() {
		return txtVerzija;
	}

	public static void setTxtVerzija(JTextField txtVerzija) {
		CustomDialog.txtVerzija = txtVerzija;
	}

	public static void setTxtPutanja(JTextField txtPutanja) {
		CustomDialog.txtPutanja = txtPutanja;
	}
	
	public static JButton getJbTraziPutanju() {
		return jbTraziPutanju;
	}
	public static void setJbTraziPutanju(JButton jbTraziPutanju) {
		CustomDialog.jbTraziPutanju = jbTraziPutanju;
	}
	
	public static JTextField getTxtPutanja() {
		return txtPutanja;
	}
	public static void setTxtPutanja(String txtPutanja) {
		CustomDialog.getTxtPutanja().setText(txtPutanja);
	}
	
	private void initTree() {
		this.rootOfOurModel = new Node("root", null);
		
		treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(this.rootOfOurModel));
		
		treeModel.setAsksAllowsChildren(true);
		tree = new JTree(treeModel) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 2789999619139248302L;

			@Override
			public boolean isPathEditable(TreePath path) {
				// Svi se mogu editovati sem root-a.
				if (path != null) {
					DefaultMutableTreeNode tn = (DefaultMutableTreeNode) path.getLastPathComponent();
					if (!tn.isRoot()) {
						return true;
					} else {
						return false;
					}
				}
				return false;
			}

		};
		tree.setEditable(true);
		tree.setCellEditor(new CellEditor(tree, null));
		tree.setCellRenderer(new NodeTreeCellRendered());
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeListener());

		KeyStroke ks = KeyStroke.getKeyStroke("F2");
		InputMap im = tree.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		im.put(ks, "edit_tree_cell");
		ActionMap am = tree.getActionMap();
		am.put("edit_tree_cell", new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1309752715414833276L;

			@Override
			public void actionPerformed(ActionEvent e) {
				tree.startEditingAtPath(tree.getSelectionPath());
			}
		});
	}
	
//	private void initCheckBoxTree() {
//		this.rootOfOurModel = new Node("root", null);
//		
//		treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(this.rootOfOurModel));
//		
//		treeModel.setAsksAllowsChildren(true);
//		tree = new JTree(treeModel) {
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 2789999619139248302L;
//
//			@Override
//			public boolean isPathEditable(TreePath path) {
//				// Svi se mogu editovati sem root-a.
//				if (path != null) {
//					DefaultMutableTreeNode tn = (DefaultMutableTreeNode) path.getLastPathComponent();
//					if (!tn.isRoot()) {
//						return true;
//					} else {
//						return false;
//					}
//				}
//				return false;
//			}
//
//		};
//		checkBoxTree.setEditable(true);
//		checkBoxTree.setCellEditor(new CellEditor(tree, null));
//		checkBoxTree.setCellRenderer(new NodeTreeCellRendered());
//		checkBoxTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//		checkBoxTree.addTreeSelectionListener(new TreeListener());
//
//		KeyStroke ks = KeyStroke.getKeyStroke("F2");
//		InputMap im = checkBoxTree.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//		im.put(ks, "edit_tree_cell");
//		ActionMap am = checkBoxTree.getActionMap();
//		am.put("edit_tree_cell", new AbstractAction() {
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1309752715414833276L;
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				checkBoxTree.startEditingAtPath(tree.getSelectionPath());
//			}
//		});
//	}
	
}
