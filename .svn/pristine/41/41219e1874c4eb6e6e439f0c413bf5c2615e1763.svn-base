package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

// Cvor moze biti : Workspace -> id = 0; Kompanija -> id = 1; Proizvod -> id = 2; Parametar >=3
public class Node {
	String name;
	int id;
	String naziv_kompanije,  sediste, predstavnik;		// kompanija za id = 1
	String naziv_proizvoda, verzija, opis_proizvoda;	// proizvod za id = 2 logo?
	String naziv_parametra, vrednost_parametra;			// parametar za id >=3
	JScrollPane logo;
	
	public String getNaziv_kompanije() {
		return naziv_kompanije;
	}

	public void setNaziv_kompanije(String naziv_kompanije) {
		this.naziv_kompanije = naziv_kompanije;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public String getPredstavnik() {
		return predstavnik;
	}

	public void setPredstavnik(String predstavnik) {
		this.predstavnik = predstavnik;
	}

	public String getNaziv_proizvoda() {
		return naziv_proizvoda;
	}

	public void setNaziv_proizvoda(String naziv_proizvoda) {
		this.naziv_proizvoda = naziv_proizvoda;
	}

	public String getVerzija() {
		return verzija;
	}

	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}

	public String getOpis_proizvoda() {
		return opis_proizvoda;
	}

	public void setOpis_proizvoda(String opis_proizvoda) {
		this.opis_proizvoda = opis_proizvoda;
	}

	public String getNaziv_parametra() {
		return naziv_parametra;
	}

	public void setNaziv_parametra(String naziv_parametra) {
		this.naziv_parametra = naziv_parametra;
	}

	public String getVrednost_parametra() {
		return vrednost_parametra;
	}

	public void setVrednost_parametra(String vrednost_parametra) {
		this.vrednost_parametra = vrednost_parametra;
	}

	public JScrollPane getLogo() {
		return logo;
	}

	public void setLogo(JScrollPane logo) {
		this.logo = logo;
	}

	Node parent;
	List<Node> children;

	public Node() {
		this.children = new ArrayList<Node>();
	}

	public Node(String name, Node parent) {
		this();
		this.name = name;
		this.parent = parent;
	}
	public Node(String name, Node parent, int id) {
		this();
		this.name = name;
		this.parent = parent;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return this.name;
	}

	// ================================
	// Manipulacija stablom
	public boolean isRoot() {
		return this.parent == null;
	}

	public void addChildren(Node newChild) {
		// TODO: eventualne provere da li je dodavanja moguce
		// dodavanje cvora
		this.children.add(newChild);
		newChild.setParent(this);
		System.out.printf("Dodat cvor: %s kao dete cvora: %s, koji ima: %d dece.\n", newChild.getName(), this.name,
				this.children.size());
	}

	public void removeChild(Node child) {
		// TODO: eventualne provere da li je brisanje moguce
		this.children.remove(child);
		child.setParent(null);
		System.out.printf("Obrisan cvor: %s od cvora: %s, koji ima: %d dece.\n", child.getName(), this.name,
				this.children.size());
	}
	
	public void removeFromParent() {
		// pozovemo parenta da nas ukloni
		this.parent.removeChild(this);
	}

	public boolean isLeaf() {
		// da li je list u modelu, ne odnosi se ne JTreeModel
		return this.children.isEmpty();
	}

}
