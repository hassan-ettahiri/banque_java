package Classes;

import java.io.Serializable;

public class Agence implements Serializable{
    /****** attribut ***********/
    private String address;
    private Banque banque;
    private Directeur directeur;
    private Employe[] employe;
    private Compte[] comptes;


    /******* constructeur ************/
    public Agence(Banque b , Directeur d) {
        this.banque = b;
        this.directeur = d;
    }
    public Agence( Banque b , Directeur d,Employe[] employes) {
        this.banque = b;
        this.directeur = d;
        this.employe = new Employe[employes.length];
        for(int i=0;i<employes.length;i++) {
            this.employe[i] = employes[i];
        }
    }


    /****** getters && setters *********/


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Employe getEmploye(int index) {
        return this.employe[index];
    }
    public Compte getCompte(int index) {
        return this.comptes[index];
    }
}

