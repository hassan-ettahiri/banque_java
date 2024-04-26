package Classes;

import java.io.Serializable;

public class Compte implements Serializable {
    /******** attribut ************/
    private int solde = 0;
    private int id , code;


    /****** constructeur ********/
    protected Compte(int solde , int id , int code) {
        this.code = code;
        this.id = id;
        this.solde = solde;
    }


    /****** methodes *********/
    public void retrait(int s) {};
    public void depot(int s) {};
    public void virement(Compte c,int s) {};
    public void Solde() {};
    public void calculInteret() {};

    public int getSolde() {
        return solde;
    }


    public void setSolde(int solde) {
        this.solde = solde;
    }




    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }
}
