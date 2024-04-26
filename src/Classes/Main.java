package Classes;

import java.io.*;
import java.util.Scanner;
public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        Banque banque = new Banque("maroc banque" , 10);
        Directeur directeur = new Directeur("youssef" , "hajaj");
        Employe[] employes = new Employe[4];
        employes[0] = new Employe("y1","h1");
        employes[1] = new Employe("y2","h2");
        employes[2] = new Employe("y3","h3");
        employes[3] = new Employe("y4","h4");
        Agence agence1 = new Agence(banque , directeur , employes);

        Client client1 = new Client(1 , "mohamed");
        boolean exit;
        int choise;
        do {
            exit = false;
            System.out.println("\t\t\tBIENVENUE Mr "+client1.getNom());
            System.out.println("1 : create account");
            System.out.println("2 : retrait");
            System.out.println("3 : depot");
            System.out.println("4 : virement");
            System.out.println("5 : solde");
            System.out.println("6 : releves bancaire");
            System.out.println("7 : Quitter");
            System.out.print("enter your choise : ");
            choise = input.nextInt();
            if(choise == 1){
                employes[0].createClientAccont(client1);
            }
            else if(choise == 2){
                client1.retrait();
            }
            else if(choise == 3){
                client1.depot();
            }
            else if(choise == 4){
                client1.virement();
            }
            else if(choise == 5){
                client1.solde();
            }
            else if(choise == 6){
                client1.releveBancaireAffiche();
            }
            else
                exit = true;
        }while(exit == false);

//		/**********************           serialization         ************************/
        FileOutputStream file = new FileOutputStream("fichier");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(banque);
        out.writeObject(directeur);
        out.writeObject(employes);
        out.writeObject(agence1);
        out.writeObject(client1);

        out.close();
        file.close();

        /********************    deserialization     **********************/
        FileInputStream f = new FileInputStream("fichier");
        ObjectInputStream in = new ObjectInputStream(f);
        Banque banque_des;
        Directeur directeur_des;
        Employe[] employes_des;
        Agence agence1_des;
        Client client1_des;
        banque_des = (Banque)in.readObject();
        directeur_des = (Directeur)in.readObject();
        employes_des = (Employe[])in.readObject();
        agence1_des = (Agence)in.readObject();
        client1_des = (Client)in.readObject();
        in.close();
        f.close();

        do {
            exit = false;
            System.out.println("\t\t\tBIENVENUE a nouveau Mr "+client1.getNom());
            System.out.println("1 : create account");
            System.out.println("2 : retrait");
            System.out.println("3 : depot");
            System.out.println("4 : virement");
            System.out.println("5 : solde");
            System.out.println("6 : releves bancaire");
            System.out.println("7 : Quitter");
            System.out.print("enter your choise : ");
            choise = input.nextInt();
            if(choise == 1){
                employes_des[0].createClientAccont(client1);
            }
            else if(choise == 2){
                client1_des.retrait();
            }
            else if(choise == 3){
                client1_des.depot();
            }
            else if(choise == 4){
                client1_des.virement();
            }
            else if(choise == 5){
                client1_des.solde();
            }
            else if(choise == 6){
                client1_des.releveBancaireAffiche();
            }
            else
                exit = true;
        }while(exit == false);
    }
}

