package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import view.MainFrame;


@SuppressWarnings("serial")
public class StatusBar extends JPanel{
	
	
	
	private StatusPane statusBarMenuDescription;
	private StatusPane statusBarLanguage;
	
	
	public StatusBar(){
		
		
		setLayout(new GridLayout(1,2,5,5));
		setBackground(Color.lightGray);
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
		
		DateFormat df=DateFormat.getDateInstance();
		String datum=df.format(new Date());
		
		
		statusBarMenuDescription=new StatusPane(datum);
		statusBarLanguage=new StatusPane(MainFrame.getResourceBundle().getString("jezik")+
										Locale.getDefault().getDisplayLanguage());
		//statusBarLanguage=new StatusPane("");
		
		add(statusBarMenuDescription);
		add(statusBarLanguage);
	}

	
	class StatusPane extends JLabel{
		
		public StatusPane(String text) {
			super(text);
			setHorizontalAlignment(CENTER);
			setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			setPreferredSize(new Dimension(200,25));
			
		}
		
		
		
	}

	public void initComponents(){
		
		statusBarLanguage.setText(MainFrame.getInstance().getResourceBundle().getString("lblJezik")+
								  Locale.getDefault().getDisplayLanguage());

		
		DateFormat df=DateFormat.getDateInstance();
		String datum=df.format(new Date());
		statusBarMenuDescription.setText(datum);
		
	}


	public StatusPane getStatusBarLanguage() {
		return statusBarLanguage;
	}


	public void setStatusBarLanguage(StatusPane statusBarLanguage) {
		this.statusBarLanguage = statusBarLanguage;
	}





	public StatusPane getStatusBarMenuDescription() {
		return statusBarMenuDescription;
	}

	public void setStatusBarMenuDescription(StatusPane statusBarMenuDescription) {
		this.statusBarMenuDescription = statusBarMenuDescription;
	}
}

