package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import view.CustomDialog;
import view.GuideDialog;

public class FileOpener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == CustomDialog.getJbTraziPutanju()) {
			// Otvaranje lokacije
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(null);
			File fajl = fileChooser.getSelectedFile();
			if(fajl != null) {
				String filePath = fajl.getAbsolutePath();
				CustomDialog.setTxtPutanja(filePath);
				
			}			
			
		} if(e.getSource() == GuideDialog.getJbTraziOdrediste()) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setDialogTitle("select folder");
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.showOpenDialog(null);
			File fajl = fileChooser.getSelectedFile();
			if(fajl!=null) {
				String filePath = fajl.getAbsolutePath();
				GuideDialog.setTxtOdrediste(filePath);
			}
		}
	}
	
}
