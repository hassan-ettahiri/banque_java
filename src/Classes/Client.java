package Classes;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
public class Client implements Serializable {
	/***** attribut *********/
	private int code;
	private String nom , prenom , address , date , releveBancaire="";
	private Compte[] compte;
	private int index = -1;
	private final int NOMBRE_MAX_COMPTES = 10;
	
	
	/****** constructeur **********/
	public Client(int code , String nom) {
		this.code = code;
		this.nom = nom;
		compte = new Compte[this.NOMBRE_MAX_COMPTES];
	}
	
	
	
	/***** methods *********/
	public void createCompteClient() {
		ClearScreen.cs();
		int id,code,choix;
		Scanner scan = new Scanner(System.in);
		if(this.index == 10) {
			System.out.println("tu ne peut pas creer un autre compte");
			return;
		}
		System.out.println("entrer les information pour cree votre compte\nentrer l ' id que tu veut pour ton compte : ");
		id = scan.nextInt();
		System.out.println("entrer l ' code que tu veut pour ton compte : ");
		code = scan.nextInt();
		this.index++;
		System.out.print("1 : Compte payant\n2 : Compte Epargne\nentrer to choix : ");
		choix = scan.nextInt();
		if(choix == 1) {
			this.compte[this.index] = new ComptePayant(0,id,code);
			this.releveBancaire = RelevesBancaireFunctions.addStringValue(this.releveBancaire, "\nutilisateur "+this.nom+"\nComptePayant cree   id = "+id+"\tcode = "+code);
		}
		else {
			this.compte[this.index] = new CompteEpargne(0,id,code);
			this.releveBancaire = RelevesBancaireFunctions.addStringValue(this.releveBancaire, "\nutilisateur "+this.nom+"\nCompteEpargne cree   id = "+id+"\tcode = "+code);
		}
			
		System.out.println("compte ("+this.compte[this.index].getId()+" , "+this.compte[this.index].getCode()+") bien cree");
		System.out.println("-----------------------------------------------\n");
	}
	public void retrait() {
		ClearScreen.cs();
		boolean found = false;
		int id,code,position=0,solde;
		Scanner scan = new Scanner(System.in);
		System.out.println("retrait d'argent :  \nentrer l ' id puis le code du compte que tu veux retrait l'argent : ");
		id = scan.nextInt();
		code = scan.nextInt();
		for(int i=0;i<=this.index;i++) {
			if(this.compte[i].getId() == id && this.compte[i].getCode() == code) {
				found = true;
				position = i;
			}
		}
		if(found == false) {
			System.out.println("tu n'a pas du compte avec ce id et code ("+id+" , "+code+")");
			return;
		}
		else {
			if(this.compte[position].getSolde() == 0) {
				System.out.println("tu n'as pas d'argent dans ce compte ");
				return;
			}
			System.out.println("tu as "+this.compte[position].getSolde()+" DH");
			System.out.println("Combien d'argent voulez-vous retirer? : ");
			do {
				System.out.println("il ne faut pas depasser : " + this.compte[position].getSolde());
				solde = scan.nextInt();
			}while(solde >= this.compte[position].getSolde() || solde < 0);
			this.compte[position].retrait(solde);
			this.releveBancaire = RelevesBancaireFunctions.addStringValue(this.releveBancaire, "\nretrait du "+solde+" DH du compte id = "+this.compte[position].getId());
		}
		System.out.println("-----------------------------------------------\n");
	}
	public void depot() {
		ClearScreen.cs();
		boolean found = false;
		int id,code,position=0,solde;
		Scanner scan = new Scanner(System.in);
		System.out.println("depot d'argent : \nentrer l ' id puis le code du compte que tu veux deposer l'argent : ");
		id = scan.nextInt();
		code = scan.nextInt();
		for(int i=0;i<=this.index;i++) {
			if(this.compte[i].getId() == id && this.compte[i].getCode() == code) {
				found = true;
				position = i;
			}
		}
		if(found == false) {
			System.out.println("tu n'a pas du compte avec ce id et code ("+id+" , "+code+")");
			return;
		}else {
			do {
				System.out.print("entrer combien d'argent tu veux deposer (pas depasser 10000) : ");
				solde = scan.nextInt();
			}while(solde < 0 || solde > 10000);
			this.compte[position].depot(solde);
			this.releveBancaire = RelevesBancaireFunctions.addStringValue(this.releveBancaire, "\ndepot du "+solde+" DH du compte id = "+this.compte[position].getId());
		}
		System.out.println("-----------------------------------------------\n");
	}
	public void solde() throws IOException {
		ClearScreen.cs();
		boolean found = false;
		int id,position=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("entrer l ' id du compte que tu veux voir son solde : ");
		id = scan.nextInt();
		for(int i=0;i<=this.index;i++) {
			if(this.compte[i].getId() == id) {
				found = true;
				position = i;
			}
		}
		if(found == false) {
			System.out.println("tu n'a pas du compte avec ce id  :"+id);
			return;
		}else {
			System.out.println("-----------------------------------------------");
			this.compte[position].Solde();
			System.out.println("-----------------------------------------------\n");
		}
	}
	public void virement() {
		ClearScreen.cs();
		boolean found = false;
		int id1,code,id2,position1=0,position2=0,solde;
		Scanner scan = new Scanner(System.in);
		/***********************************/
		System.out.println("envoyer l'argent a une autre personne : \nentrer l ' id et code du votre compte : ");
		id1 = scan.nextInt();
		code = scan.nextInt();
		for(int i=0;i<=this.index;i++) {
			if(this.compte[i].getId() == id1 && code == this.compte[i].getCode()) {
				found = true;
				position1 = i;
			}
		}
		if(found == false) {
			System.out.println("il n y 'a pas du compte avec ce id  :"+id1);
			return;
		}
		/******************************************/
		System.out.println("entrer l ' id du compte que tu veux le passer l'argent : ");
		id2 = scan.nextInt();
		for(int i=0;i<=this.index;i++) {
			if(this.compte[i].getId() == id2) {
				found = true;
				position2 = i;
			}
		}
		if(found == false) {
			System.out.println("il n y 'a pas du compte avec ce id  :"+id2);
			return;
		}
		/*************************************************/
		else {
			if(this.compte[position1].getSolde() == 0) {
				System.out.println("tu n'as pas d'argent dans ce compte pour l'envoyer ");
				return;
			}
			System.out.print("entrer combien d'argent tu veux passer : ");
			do {
				System.out.println("il ne faut pas depasser : " + this.compte[position1].getSolde());
				solde = scan.nextInt();
			}while(solde >= this.compte[position1].getSolde());
			this.compte[position1].virement(this.compte[position2], solde);
			this.releveBancaire = RelevesBancaireFunctions.addStringValue(this.releveBancaire, "\nvirement du "+solde+" DH du compte id = "+this.compte[position1].getId()+" vers compte id = "+this.compte[position2].getId());
		}
		System.out.println("-----------------------------------------------\n");
	}
	public void releveBancaireAffiche() {
		ClearScreen.cs();
		System.out.println("-----------------------------------------------");
		System.out.println(this.releveBancaire);
		System.out.println("-----------------------------------------------\n");
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
