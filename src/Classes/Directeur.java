package Classes;

import java.io.Serializable;

public class Directeur implements Serializable {
	/****** attribut ************/
	private String nom;
	private String prenom;
	private String dateEmbauch;
	
	
	/******** constructeur **********/
	public Directeur(String nom , String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	/******** getters setters **************/
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateEmbauch() {
		return dateEmbauch;
	}

	public void setDateEmbauch(String dateEmbauch) {
		this.dateEmbauch = dateEmbauch;
	}
	
}
