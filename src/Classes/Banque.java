package Classes;

import java.io.Serializable;

public class Banque implements Serializable {

    /******** attribut ******************/
    private Agence[] agences;
    private int index = -1;
    private int nombreAgence;
    private String nom;
    private String capital_global;
    private double siège_socia;


    /********* constructeur ***************/
    public Banque(String nom,int nombreAgence) {
        this.nom = nom;
        this.nombreAgence = nombreAgence;
        this.agences = new Agence[nombreAgence];
    }


    /********* getters && setters **********/
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCapital_global() {
        return capital_global;
    }
    public void setCapital_global(String capital_global) {
        this.capital_global = capital_global;
    }
    public double getSiège_socia() {
        return siège_socia;
    }
    public void setSiège_socia(double siège_socia) {
        this.siège_socia = siège_socia;
    }
    public void addAgence(Agence a) {
        if(this.index < this.nombreAgence) {
            this.index++;
            this.agences[this.index] = a;
        }else {
            System.out.println("il n'y a pas de place pour ajouter cette agence!!");
        }
    }
}
