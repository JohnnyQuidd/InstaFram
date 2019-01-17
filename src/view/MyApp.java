package view;

import javax.swing.UIManager;

import controllers.WritingProperties;

public class MyApp {

	public static void main(String[] args) {
		
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch(Exception e){
			System.out.println("Couldn't load look and feel");
		}
				
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		

		
	}

}
