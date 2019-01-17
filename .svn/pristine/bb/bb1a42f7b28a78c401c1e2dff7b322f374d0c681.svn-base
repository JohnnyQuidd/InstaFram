package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


import controllers.AddNodeAction;
import controllers.DodajButton;
import controllers.ListenForSwitchButton;
import controllers.ListenForTextEntry;
import controllers.ProizvodControler;
import controllers.RemoveNodeAction;
import controllers.SafeClose;
import controllers.SearchNodeAction;
import controllers.TreeListener;
import view.MainFrame;
import view.StatusBar;
import model.Node;
import net.miginfocom.swing.MigLayout;
import view.tree.CellEditor;
import view.tree.NodeTreeCellRendered;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static MainFrame instance = null;
	
	// Lokalizacija
	private static ResourceBundle resourceBundle;
	private static StatusBar statusBar;
	

	JTree tree;
	DefaultTreeModel treeModel;
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}
	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	Node rootOfOurModel;
	
	private JPanel pnlActions;	
	private JButton btnAdd;
	

	private JButton btnRemove;
	private JButton btnSearch;
	
	JTextField txtNazivProizvoda;
	JTextField txtVerzijaProizvoda;
	public static JLabel lblPhoto;
	public static JLabel getLblPhoto() {
		return lblPhoto;
	}
	public static void setLblPhoto(JLabel lblPhoto) {
		MainFrame.lblPhoto = lblPhoto;
	}
	public JTextField getTxtSediste() {
		return txtSediste;
	}
	public void setTxtSediste(JTextField txtSediste) {
		this.txtSediste = txtSediste;
	}

	///////////////////////////////////////
	private JTextField txtNazKompanije, txtSediste, txtPredstavnik, txtParametar, txtVrednostParametra;
	private JButton jbDodajProizvod, jbOdustaniProizvod, jbDodajParametar, jbOdustaniParametar, btnEdit, jbApply;
	private JPanel velikiPanel;
	private JLabel lblLogo;
	private JButton jbDialog;
	public static JButton instalator;
	
	public static StatusBar getStatusBar() {
		return statusBar;
	}
	public static void setStatusBar(StatusBar statusBar) {
		MainFrame.statusBar = statusBar;
	}
	
	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	public static void setResourceBundle(ResourceBundle resourceBundle) {
		MainFrame.resourceBundle = resourceBundle;
	}
	
	public static JButton getInstalator() {
		return instalator;
	}
	public static void setInstalator(JButton instalator) {
		MainFrame.instalator = instalator;
	}
	public JTree getJTree() {
		return tree;
	}
	
	public void setJTree(JTree tree) {
		this.tree = tree;
	}
	
	public JButton getJbDialog() {
		return jbDialog;
	}
	public void setJbDialog(JButton jbDialog) {
		this.jbDialog = jbDialog;
	}
	public JPanel getVelikiPanel() {
		return velikiPanel;
	}
	public void setVelikiPanel(JPanel velikiPanel) {
		this.velikiPanel = velikiPanel;
	}
	public JButton getJbApply() {
		return jbApply;
	}
	public void setJbApply(JButton jbApply) {
		this.jbApply = jbApply;
	}

	private JScrollPane paneLogo;
	
	public JScrollPane getPaneLogo() {
		return paneLogo;
	}
	public void setPaneLogo(JScrollPane paneLogo) {
		this.paneLogo = paneLogo;
	}
	public JButton getBtnEdit() {
		return btnEdit;
	}
	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	public JButton getJbDodajParametar() {
		return jbDodajParametar;
	}
	public void setJbDodajParametar(JButton jbDodajParametar) {
		this.jbDodajParametar = jbDodajParametar;
	}
	public JTextField getTxtParametar() {
		return txtParametar;
	}
	public void setTxtParametar(JTextField txtParametar) {
		this.txtParametar = txtParametar;
	}
	public JTextField getTxtVrednostParametra() {
		return txtVrednostParametra;
	}
	public void setTxtVrednostParametra(JTextField txtVrednostParametra) {
		this.txtVrednostParametra = txtVrednostParametra;
	}
	public JButton getJbOdustaniParametar() {
		return jbOdustaniParametar;
	}
	public void setJbOdustaniParametar(JButton jbOdustaniParametar) {
		this.jbOdustaniParametar = jbOdustaniParametar;
	}

	private JTextArea txtOpisProizvoda;
	private JButton jbDodajKompaniju, jbUbaciSliku, JbOdustani, jbUkloniSliku;
	private JButton jbSwitch, jbKompanija, jbProizvod, jbParametar;
	private CardLayout c1;
	private JPanel cardPanel;
	/////////////////////
	
	public JPanel getCardPanel() {
		return cardPanel;
	}
	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}
	public CardLayout getC1() {
		return c1;
	}
	public void setC1(CardLayout c1) {
		this.c1 = c1;
	}
	public JButton getJbSwitch() {
		return jbSwitch;
	}
	public void setJbSwitch(JButton jbSwitch) {
		this.jbSwitch = jbSwitch;
	}
	public JButton getJbKompanija() {
		return jbKompanija;
	}
	public void setJbKompanija(JButton jbKompanija) {
		this.jbKompanija = jbKompanija;
	}
	public JButton getJbProizvod() {
		return jbProizvod;
	}
	public void setJbProizvod(JButton jbProizvod) {
		this.jbProizvod = jbProizvod;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	int brKompanija = 0;
	int brParametara = 0;
	int brPodparametara = 0;
	
	// JScrollPane i kao parametar se prosledjuje JTree
	private MainFrame() {
		Locale.setDefault(new Locale("en","US"));
		resourceBundle =ResourceBundle.getBundle( "view.MessageResources.MessageResources", Locale.getDefault());
				
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		
		int screenHeight = (int) dim.getHeight();
		int screenWidth = (int) dim.getWidth();
		
		SafeClose sClose = new SafeClose();
		this.addWindowListener(sClose);
		
		
		setSize(960, 540);
		//setPreferredSize(new Dimension(screenWidth/2 , screenHeight/2));
		setTitle("InstaFram");		
		setLocationRelativeTo(null);
		
		
		MainMenu mojMeni = new MainMenu();
		mojMeni.setPreferredSize(new Dimension(100,25));
		add(mojMeni, BorderLayout.NORTH);
		
		initTree();
		initPnlActions();
		
		// Sada cemo napraviti levi ScrollPane
		JPanel leftPane = new JPanel(new BorderLayout(0,0));
		leftPane.setPreferredSize(new Dimension(300,200));
		leftPane.setMinimumSize(new Dimension(100,200));
		JScrollPane s1 = new JScrollPane(tree, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		s1.setPreferredSize(new Dimension(250,30));
		s1.setMinimumSize(new Dimension(100,30));
		
		
		// U lower panelu se nalazi status bar
		JPanel lowerPanel = new JPanel(new BorderLayout(0,0));
		lowerPanel.setPreferredSize(new Dimension(50,30));
		
		JLabel status_bar = new JLabel("Status Bar");
		
		statusBar = new StatusBar();
		//statusBar.initComponents();
		
		// Dodavanje elemenata posebno, van status bar-a
		//lowerPanel.add(status_bar);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setPreferredSize(new Dimension(this.getWidth(), 35));
					
		//toolBar.add(pnlActions);
		jbSwitch = new JButton(MainFrame.getResourceBundle().getString("radni_prostor"));
		jbKompanija = new JButton(MainFrame.getResourceBundle().getString("kompanija"));
		jbProizvod = new JButton(MainFrame.getResourceBundle().getString("proizvod"));
		jbParametar = new JButton(MainFrame.getResourceBundle().getString("parametar"));
		
		//toolBar.add(btnAdd);
		//btnAdd.setMnemonic(KeyEvent.VK_I);
		//btnAdd.setToolTipText("Dodaj novi parametar (ALT + A)");
		btnEdit = new JButton(MainFrame.getResourceBundle().getString("izmeni"));
		jbApply = new JButton(MainFrame.getResourceBundle().getString("primeni"));
		jbDialog = new JButton(MainFrame.getResourceBundle().getString("dijalog"));
		
		btnEdit.setMnemonic(KeyEvent.VK_E);
		btnEdit.setToolTipText("(ALT + E)");
		btnEdit.addActionListener(new ListenForSwitchButton());
		toolBar.add(btnEdit);
		toolBar.addSeparator();
		btnRemove.setText(MainFrame.getResourceBundle().getString("izbrisi_selektovani_cvor"));
		toolBar.add(btnRemove);
		btnRemove.setMnemonic(KeyEvent.VK_D);
		btnRemove.setToolTipText("(ALT + R)");
		toolBar.addSeparator();
		btnSearch.setText(MainFrame.getResourceBundle().getString("trazi"));
		toolBar.add(btnSearch);
		btnSearch.setMnemonic(KeyEvent.VK_S);
		btnSearch.setToolTipText("(ALT + S)");
		toolBar.addSeparator();
		toolBar.add(jbSwitch);
		jbSwitch.setMnemonic(KeyEvent.VK_W);
		toolBar.addSeparator();
		toolBar.add(jbKompanija);
		jbKompanija.setMnemonic(KeyEvent.VK_K);
		toolBar.addSeparator();
		jbProizvod.setMnemonic(KeyEvent.VK_P);
		toolBar.add(jbProizvod);
		toolBar.addSeparator();
		jbParametar.setMnemonic(KeyEvent.VK_R);
		toolBar.add(jbParametar);
		toolBar.addSeparator();
		jbApply.setMnemonic(KeyEvent.VK_A);
		jbApply.setToolTipText("(ALT + A)");
		jbApply.addActionListener(new DodajButton());
		toolBar.add(jbApply);	
		toolBar.addSeparator();
		
		jbDialog.setMnemonic(KeyEvent.VK_B);
		//jbDialog.setToolTipText("Otvara DialogBox");
		jbDialog.addActionListener(new DodajButton());
		toolBar.add(jbDialog);
		toolBar.addSeparator();
		
		instalator = new JButton(MainFrame.getResourceBundle().getString("instalator"));
		instalator.setMnemonic(KeyEvent.VK_I);
		instalator.addActionListener(new DodajButton());
		toolBar.add(instalator);
		toolBar.addSeparator();
	
		
		leftPane.add(s1);
		
		JPanel mainPane = new JPanel(new BorderLayout(0,0));
		mainPane.setPreferredSize(new Dimension(600,400));
		mainPane.setBackground(new Color(22,44,33));
		
		
		add(statusBar, BorderLayout.SOUTH);
		
		mainPane.add(toolBar, BorderLayout.NORTH);
		mainPane.add(leftPane, BorderLayout.WEST);
		
		//Sada je neophodno od mainPan-a napraviti podeljenji pane na gornji i donji deo
		// MigLayout cemo dodati u veliki panel
		velikiPanel = new JPanel(new BorderLayout(0,0));
		velikiPanel.setLayout(new MigLayout("","[][]1[]", "[]1[]"));
		
		//velikiPanel.setBackground(Color.gray);
		
		txtNazivProizvoda = new JTextField("",50);
		txtVerzijaProizvoda = new JTextField("",50);
		
		JLabel lblNazivProizvoda = new JLabel(MainFrame.getResourceBundle().getString("naziv_proizvoda"));
		
		JLabel lblVerzijaProizvoda = new JLabel(MainFrame.getResourceBundle().getString("verzija"));
		
		lblLogo = new JLabel(MainFrame.getResourceBundle().getString("logo"));
		
		jbUbaciSliku = new JButton(MainFrame.getResourceBundle().getString("ubaci_sliku"));
		jbUkloniSliku = new JButton(MainFrame.getResourceBundle().getString("ukloni_sliku"));
		//jbDodaj = new JButton("Dodaj");
		
		JbOdustani = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		//jbDodaj = new JButton(new AddNodeAction("Dodaj"));
		jbDodajKompaniju = new JButton(MainFrame.getResourceBundle().getString("dodaj"));
		jbDodajKompaniju.addActionListener(new DodajButton());
		
		
		jbDodajProizvod = new JButton(MainFrame.getResourceBundle().getString("dodaj"));
		jbDodajProizvod.setPreferredSize(new Dimension(15,5));
		jbOdustaniProizvod = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		jbOdustaniProizvod.setPreferredSize(new Dimension(15,5));
		jbDodajProizvod.addActionListener(new DodajButton());
		
		

		
		
		// 
		//jbDodaj smesti u kompaniju
		paneLogo = new JScrollPane();
		paneLogo.setPreferredSize(new Dimension(450,900));
		
		lblPhoto = new JLabel();
		lblPhoto.setPreferredSize(new Dimension(455,900));
		lblPhoto.setMaximumSize(new Dimension(455,900));
		lblPhoto.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// nepotrebno
		paneLogo.add(lblPhoto);
		//
		
//		jbDodajProizvod.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ok();
//			}
//		});
		
		JLabel lblOpisProizvoda = new JLabel(MainFrame.getResourceBundle().getString("opis_proizvoda"));
		txtOpisProizvoda = new JTextArea("",50, 50);
		txtOpisProizvoda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		txtOpisProizvoda.setLineWrap(true);
		txtOpisProizvoda.setWrapStyleWord(true);
		
		// ubaci sliku ukloni sliku pane
		// column row width height
		velikiPanel.add(lblNazivProizvoda, "cell 0 0");
		velikiPanel.add(txtNazivProizvoda, "cell 1 0, pushx, growx");	// pushx, growx
		velikiPanel.add(lblVerzijaProizvoda, "cell 0 1");
		velikiPanel.add(txtVerzijaProizvoda, "cell 1 1, pushx, growx");
		
		velikiPanel.add(lblOpisProizvoda, "cell 0 2");
		velikiPanel.add(txtOpisProizvoda, "cell 1 2, , pushx, growx");
		
		velikiPanel.add(lblLogo, "cell 0 3");
		velikiPanel.add(lblPhoto, "cell 1 3, span 2 2, pushx, growx");
		//velikiPanel.add(labelaLogo, "cell 1 3, span 2 2, pushx, growx");
		velikiPanel.add(jbUbaciSliku, "cell 4 3, wrap");
		velikiPanel.add(jbUkloniSliku, "cell 4 4, top");
		velikiPanel.add(jbDodajProizvod, "cell 4 5, split 2");
		velikiPanel.add(JbOdustani, "cell 5 5");
		
//		 pack();
		
		ListenForTextEntry txtListener = new ListenForTextEntry();
		txtNazivProizvoda.addFocusListener(txtListener);
		txtVerzijaProizvoda.addFocusListener(txtListener);
		txtOpisProizvoda.addFocusListener(txtListener);
		// Prazan panel koji ce sluziti kao druga komponenta pri CardLayout-u
		JPanel secondPanel = new JPanel(new BorderLayout(0,0));
		//JButton jbSwitch2 = new JButton("Switch to pane1");
		
		JPanel thirdPanel = new JPanel(new BorderLayout(0,0));
		thirdPanel.setLayout(new MigLayout("","[][]1[]", "[]1[]"));
		
		
		JLabel lblNazKompanije = new JLabel(MainFrame.getResourceBundle().getString("naziv_kompanije"));
		JLabel lblSediste = new JLabel(MainFrame.getResourceBundle().getString("sediste"));
		JLabel lblPredstavnik = new JLabel(MainFrame.getResourceBundle().getString("predstavnik"));
		
		txtNazKompanije = new JTextField("", 50);
		txtNazKompanije.addFocusListener(txtListener);
		txtSediste = new JTextField("", 50);
		txtSediste.addFocusListener(txtListener);
		txtPredstavnik = new JTextField("", 50);
		txtPredstavnik.addFocusListener(txtListener);
		
		
		
		// kolona red
		thirdPanel.add(lblNazKompanije, "cell 0 0");
		thirdPanel.add(txtNazKompanije, "cell 1 0, wrap, pushx, growx");
		thirdPanel.add(lblSediste, "cell 0 1");
		thirdPanel.add(txtSediste, "cell 1 1, wrap, pushx, growx");
		thirdPanel.add(lblPredstavnik, "cell 0 2");
		thirdPanel.add(txtPredstavnik, "cell 1 2, wrap, pushx, growx");
		thirdPanel.add(jbDodajKompaniju, "pos 65% 90%");
		thirdPanel.add(jbOdustaniProizvod, "pos 80% 90%");
		
		
		// cardPanel ce biti panel na kom ce se menjati izgledi
		cardPanel = new JPanel(new BorderLayout(0,0));
		c1 = new CardLayout();
		cardPanel.setLayout(c1);
		cardPanel.add(velikiPanel, "1");		// parametar
		velikiPanel.setName("velikiPanel");
		cardPanel.add(secondPanel, "2");		// blank
		secondPanel.setName("secondPanel");
		cardPanel.add(thirdPanel, "3");			// kompanija
		thirdPanel.setName("thirdPanel");
		
		JPanel param = new JPanel(new BorderLayout(0,0));
		JLabel nazParametra = new JLabel(MainFrame.getResourceBundle().getString("naziv_parametra"));
		JLabel vredParametra = new JLabel(MainFrame.getResourceBundle().getString("vrednost_parametra"));
		txtParametar = new JTextField("",50);
		txtParametar.addFocusListener(new ListenForTextEntry());
		txtVrednostParametra = new JTextField("",50);
		txtVrednostParametra.addFocusListener(new ListenForTextEntry());
		jbDodajParametar = new JButton(MainFrame.getResourceBundle().getString("dodaj"));
		jbOdustaniParametar = new JButton(MainFrame.getResourceBundle().getString("odustani"));
		
		// da li si uneo vrednost pri dodavanju u stablo
		jbDodajParametar.addActionListener(new DodajButton());
		//jbOdustani za sada ne radi nista
		
		param.setLayout(new MigLayout());
		param.add(nazParametra, "cell 0 0");
		param.add(txtParametar, "cell 1 0, wrap, pushx, growx");
		param.add(vredParametra, "cell 0 1");
		param.add(txtVrednostParametra, "cell 1 1, wrap, pushx, growx");
		param.add(jbDodajParametar,"pos 65% 90%");
		param.add(jbOdustaniParametar,"pos 80% 90%");
		
		cardPanel.add(param, "4");
		c1.show(cardPanel, "2");
		
		ListenForSwitchButton jSwitch = new ListenForSwitchButton();
		jbKompanija.addActionListener(jSwitch);
		jbProizvod.addActionListener(jSwitch);
		jbSwitch.addActionListener(jSwitch);
		jbParametar.addActionListener(jSwitch);
		
		// DODAJ button vrsi prelaz na drugi layout
		jbKompanija.setToolTipText("(ALT + K)");

		jbProizvod.setToolTipText("(ALT + P)");

		jbSwitch.setToolTipText("(ALT + W)");
		
		jbParametar.setToolTipText("(ALT + A)");
		
		jbUbaciSliku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				uploadPhoto();
				jbUbaciSliku.revalidate();
			}
		});
		
		jbUkloniSliku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deletePhoto();
			}
		});
		
				
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPane, cardPanel);
		splitPane.setDividerLocation(250);
		splitPane.setMinimumSize(new Dimension(50,100));
		
		
		tree.addTreeSelectionListener(new TreeListener());
		
		mainPane.add(splitPane);
		add(mainPane, BorderLayout.CENTER);
		
		ImageIcon img = new ImageIcon("images/instaframNew.png");
		this.setIconImage(img.getImage());
		
		
	}
	public JButton getJbParametar() {
		return jbParametar;
	}
	public void setJbParametar(JButton jbParametar) {
		this.jbParametar = jbParametar;
	}
	public JTextField getTxtVerzijaProizvoda() {
		return txtVerzijaProizvoda;
	}
	public void setTxtVerzijaProizvoda(JTextField txtVerzijaProizvoda) {
		this.txtVerzijaProizvoda = txtVerzijaProizvoda;
	}
	public JTextField getTxtNazivProizvoda() {
		return txtNazivProizvoda;
	}
	public void setTxtNazivProizvoda(JTextField txtNazivProizvoda) {
		this.txtNazivProizvoda = txtNazivProizvoda;
	}
	public JTextField getTxtNazKompanije() {
		return txtNazKompanije;
	}
	public void setTxtNazKompanije(JTextField txtNazKompanije) {
		this.txtNazKompanije = txtNazKompanije;
	}
	
	public JButton getjbProizvod() {
		return jbProizvod;
	}
	
	public JTextField getTxtPredstavnik() {
		return txtPredstavnik;
	}
	public void setTxtPredstavnik(JTextField txtPredstavnik) {
		this.txtPredstavnik = txtPredstavnik;
	}
	public JButton getJbDodajProizvod() {
		return jbDodajProizvod;
	}
	public void setJbDodajProizvod(JButton jbDodajProizvod) {
		this.jbDodajProizvod = jbDodajProizvod;
	}
	public JButton getJbOdustaniProizvod() {
		return jbOdustaniProizvod;
	}
	public void setJbOdustaniProizvod(JButton jbOdustaniProizvod) {
		this.jbOdustaniProizvod = jbOdustaniProizvod;
	}
	public JTextArea getTxtOpisProizvoda() {
		return txtOpisProizvoda;
	}
	public void setTxtOpisProizvoda(JTextArea txtOpisProizvoda) {
		this.txtOpisProizvoda = txtOpisProizvoda;
	}
	public JButton getJbDodajKompaniju() {
		return jbDodajKompaniju;
	}
	public void setJbDodajKompaniju(JButton jbDodaj) {
		this.jbDodajKompaniju = jbDodaj;
	}
	public JButton getJbUbaciSliku() {
		return jbUbaciSliku;
	}
	public void setJbUbaciSliku(JButton jbUbaciSliku) {
		this.jbUbaciSliku = jbUbaciSliku;
	}
	public JButton getJbOdustani() {
		return JbOdustani;
	}
	public void setJbOdustani(JButton jbOdustani) {
		JbOdustani = jbOdustani;
	}
	public JButton getJbUkloniSliku() {
		return jbUkloniSliku;
	}
	public void setJbUkloniSliku(JButton jbUkloniSliku) {
		this.jbUkloniSliku = jbUkloniSliku;
	}
	private void ok() {
		String nazProizvoda = txtNazivProizvoda.getText();
		String verzProiz = txtVerzijaProizvoda.getText();
		Image photo = null;
		if (lblPhoto.getIcon() != null) {
			photo = ((ImageIcon) lblPhoto.getIcon()).getImage();
		}

		// proizvod controller sam promenio u static
		String message = ProizvodControler.updateProizvod(nazProizvoda, verzProiz, photo);

		java.awt.Window parent = SwingUtilities.getWindowAncestor(this);
		// Kako biste prikazali warning dijalog ako je ažuriranje modela prošlo
		// neuspešno?
		JOptionPane.showMessageDialog(parent, message);
	}
	
	private void deletePhoto() {
		lblPhoto.setIcon(null);
	}
	
	private void uploadPhoto() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
			lblPhoto.setIcon(icon);
			
		}
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
	
	private void initPnlActions() {
		pnlActions = new JPanel();

//		if(MainFrame.getInstance().getTxtNazKompanije().getText().trim().length()==0) {
//			btnAdd = new JButton("Insert Node");
//		} else {
//			btnAdd = new JButton(new AddNodeAction("Insert Node"));
//		}
		
		btnAdd = new JButton(new AddNodeAction("Insert Node"));
		btnAdd.addActionListener(new DodajButton());
		btnRemove = new JButton(new RemoveNodeAction("Remove Selected Node"));
		btnSearch = new JButton(new SearchNodeAction("Search"));

		pnlActions.add(btnAdd);
		pnlActions.add(btnRemove);
		pnlActions.add(btnSearch);
		pnlActions.setFocusable(true);

		pnlActions.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("key typed " + e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key pressed " + e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("key released" + e.getKeyChar());
			}

		});
		pnlActions.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pnlActions.requestFocusInWindow();
			}

		});

	}
	
	public JTree getTree() {
		return tree;
	}
	
	public String getTextField() {
		return txtNazivProizvoda.getText();
	}

	public DefaultTreeModel getModel() {
		return treeModel;
	}
	
	// Implementacija Singleton Pattern-a
	public static MainFrame getInstance() {
		if(instance==null) {
			instance=new MainFrame();
		}
			
		return instance;
	}
}
