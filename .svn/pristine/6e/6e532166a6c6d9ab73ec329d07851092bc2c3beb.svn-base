package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import controllers.AboutHandler;
import controllers.HelpAction;

import javax.swing.JMenu;
public class MainMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainMenu() {
		JMenuBar meniBar = new JMenuBar();
		JMenu file = new JMenu(MainFrame.getResourceBundle().getString("fajl"));
		//file.setToolTipText("Rad sa datotekama");
		// new ce takodje biti meni, gde ce se birati projekat/workspace
		JMenu NEW = new JMenu(MainFrame.getResourceBundle().getString("novi"));
		NEW.setIcon(new ImageIcon("images/browser.png"));
		NEW.addSeparator();
		JMenuItem project = new JMenuItem(MainFrame.getResourceBundle().getString("projekat"));
		project.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem workspace = new JMenuItem(MainFrame.getResourceBundle().getString("radni_prostor"));
		workspace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		
		
		// dalje u file ide save i save as
		JMenuItem save = new JMenuItem(MainFrame.getResourceBundle().getString("sacuvaj"));
		save.setIcon(new ImageIcon("images/diskette.png"));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem saveAs = new JMenuItem(MainFrame.getResourceBundle().getString("sacuvaj_kao"));
		saveAs.setIcon(new ImageIcon("images/floppy-disk.png"));
		saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		
		JMenu edit = new JMenu(MainFrame.getResourceBundle().getString("izmeni"));
		//edit.setToolTipText("Modifikacija datoteka");
		JMenu help = new JMenu(MainFrame.getResourceBundle().getString("pomoc"));
		HelpAction helpAction = new HelpAction();
		help.addMenuListener(helpAction);
		JMenu about = new JMenu(MainFrame.getResourceBundle().getString("o_nama"));
		AboutHandler aboutHandler = new AboutHandler();
		about.addMenuListener(aboutHandler);
		JMenuItem rootDirectory = new JMenuItem(MainFrame.getResourceBundle().getString("maticna_direktorija"));
		rootDirectory.setIcon(new ImageIcon("images/root-directory.png"));
		JMenu pref = new JMenu(MainFrame.getResourceBundle().getString("preferencije"));
		JMenuItem font = new JMenuItem(MainFrame.getResourceBundle().getString("font"));
		font.setIcon(new ImageIcon("images/font.png"));
		JMenuItem theme = new JMenuItem(MainFrame.getResourceBundle().getString("tema"));
		theme.setIcon(new ImageIcon("images/theme.png"));
		
		JMenu navigate = new JMenu(MainFrame.getResourceBundle().getString("alat"));
		JCheckBoxMenuItem link = new JCheckBoxMenuItem(MainFrame.getResourceBundle().getString("uvezi_novi_projekat"));
		
		
		NEW.add(project);
		NEW.add(workspace);
		
		edit.add(rootDirectory);
		pref.add(font);
		pref.add(theme);
		
		edit.add(pref);
		
		file.add(NEW);
		file.add(save);
		file.add(saveAs);
		
		navigate.add(link);
		
		meniBar.add(file);
		meniBar.add(edit);
		meniBar.add(navigate);
		
		
		meniBar.add(Box.createHorizontalGlue());
		
		meniBar.add(help, new FlowLayout(FlowLayout.RIGHT));
		meniBar.add(about, new FlowLayout(FlowLayout.RIGHT));
		
		add(meniBar, BorderLayout.NORTH);
		
	}
}
