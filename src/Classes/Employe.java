package Classes;

import java.io.Serializable;

public class Employe implements Serializable {
	/****** attribut ************/
	private String nom;
	private String prenom;
	private String dateEmbauch;
	private Agence agence;
	
	/******** constructeur **********/
	public Employe(String nom , String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Employe(String nom , String prenom , Agence a){
		this.nom = nom;
		this.prenom = prenom;
		this.agence = a;
	}
	
	
	/******** getters setters **************/
	public void createClientAccont(Client c) {
		c.createCompteClient();
	}
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
