package guidePackage;

import javax.swing.UIManager;

import view.GuideDialog;


public class MyAppGuide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch(Exception e){
			System.out.println("Couldn't load look and feel");
		}
		
		GuideDialog guide = new GuideDialog();
	}

}
