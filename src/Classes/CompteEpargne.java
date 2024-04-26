package Classes;

import java.io.Serializable;

public class CompteEpargne extends Compte implements Serializable {
	/**** attribut ****/
	private final int TAUX_INTERET = 6;
	
	/**** constructeur *********/
	public CompteEpargne(int solde , int id , int code) {
		super(solde,id,code);
	}
	
	/****** methods *********/
	public void calculInteret() {
		this.setSolde(this.getSolde() - this.getSolde() * this.TAUX_INTERET / 100);
	}
	public void retrait(int solde) {
		this.setSolde(this.getSolde() - solde);
	}
	public void depot(int solde) {
		this.setSolde(this.getSolde() + solde);
	}
	public void virement(Compte c ,int solde) {
		c.setSolde(c.getSolde() + solde);
	}
	public void Solde() {
		System.out.println("CompteEpargne : id = "+this.getId()+"\t\tsolde = "+this.getSolde());
	}
}
