package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;

import view.CustomDialog;

/*
 *  procita sve datoteke i napravi jednu izlaznu properties.ini datoteku 
 *  kljuc svake linije je naziv parametra, a vrednost je njegova vrednost
 *  
 *  
 *  Preko ObjectOutputStream napraviti setup.xxx (neka nasa ekstenzija), WriteObject metodom upisati:
 *  - Sadrzaj properties.ini 	(propertis datoteka je serijazibilna)
 *  - Kompletan binarni sadrzaj zip datoteke (izvor)
 *  - Welcome, Licenca, Verzija
 * 
 * */

public class WritingProperties{
	public static HashMap<String, String> parametri = DodajButton.getPreuzmi();
	private static Properties p = new Properties();
	private static OutputStream oStream;
	
	public WritingProperties() throws Exception{
		
		
		oStream = new FileOutputStream("properties.ini");
				
		for (String name: parametri.keySet()){

            String key =name.toString();
            String value = parametri.get(name).toString();  
            p.setProperty(key, value);
		}
		
		InputStream iStream = new FileInputStream("properties.ini");
		p.list(System.out);
	}

	public static HashMap<String, String> getParametri() {
		return parametri;
	}

	public static void setParametri(HashMap<String, String> parametri) {
		WritingProperties.parametri = parametri;
	}

	public static Properties getP() {
		return p;
	}

	public static void setP(Properties p) {
		WritingProperties.p = p;
	}

	public static OutputStream getoStream() {
		return oStream;
	}

	public static void setoStream(OutputStream oStream) {
		WritingProperties.oStream = oStream;
	}
	
}
