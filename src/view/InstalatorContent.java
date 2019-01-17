package view;

import java.io.Serializable;

public class InstalatorContent implements Serializable {

	/**
	 * 
	 */
	// sklanjanje static sa svih polja
	private static final long serialVersionUID = 1L;
	private String welcomeText, licence, verzija, izvor;

	public InstalatorContent() {
		welcomeText = "";
		licence = "";
		verzija = "";
	}
	
	public InstalatorContent(String welcomeText, String licence, String verzija, String izvor) {
		this.welcomeText = welcomeText;
		this.licence = licence;
		this.verzija = verzija;
		this.izvor = izvor;
	}
	
	
	public String getIzvor() {
		return izvor;
	}

	public void setIzvor(String izvor) {
		this.izvor = izvor;
	}


	public String getWelcomeText() {
		return welcomeText;
	}

	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getVerzija() {
		return verzija;
	}

	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
