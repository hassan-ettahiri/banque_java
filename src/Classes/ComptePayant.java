package Classes;

import java.io.Serializable;

public class ComptePayant extends Compte implements Serializable {
	/****** attribut *******/ 
	private final int COUT = 5;
	
	/****** constructeur *******/
	public ComptePayant(int solde,int id,int code) {
		super(solde,id,code);
	}
	
	/*****  methods *****/
	public void retrait(int solde) {
		this.setSolde(this.getSolde() - solde - this.COUT);
		if(this.getSolde() < 0)
			this.setSolde(0);
	}
	public void depot(int solde) {
		this.setSolde(this.getSolde() + solde - this.COUT);
		if(this.getSolde() < 0)
			this.setSolde(0);
	}
	public void virement(Compte c ,int solde) {
		c.setSolde(c.getSolde() + solde - this.COUT);
		if(this.getSolde() < 0)
			this.setSolde(0);
	}
	public void Solde() {
		System.out.println("comptePayant : id = "+this.getId()+"\t\tsolde = "+this.getSolde());
	}
	
}
