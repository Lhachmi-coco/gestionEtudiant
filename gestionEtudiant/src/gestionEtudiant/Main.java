package gestionEtudiant;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import gestionEtudiant.dao.EtudiantDAO;
import gestionEtudiant.model.Civilite;
import gestionEtudiant.model.Etudiant;

public class Main {

	public static void main(String[] args) {
		
		EtudiantDAO etudiantdao = new  EtudiantDAO() ;
	
		String nom = null;
		String prenom = null;
		String email = null;
		Civilite civilite = Civilite.Monsieur ;
		Scanner sc = new Scanner(System.in) ;
		
		int p =0 ;
		
		while(true) {
			int i ;
			System.out.println("1-Ajouter un nouveau Etudiant");
			System.out.println("2-Afficher la liste complète des étudiants dans la console");
			System.out.println("3-Supprimer un étudiant par nom");
			System.out.println("4-Trier la liste des étudiants par nom ascendant");
			System.out.println("5-Trier la liste des étudiants par date de naissance descendant");
			System.out.println("6-fermer le programme");
			System.out.println("Numero de l'operation ");
			p = sc.nextInt();
			switch (p) {
			
			case 1:{	
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
				
				Date date=null;
				
			System.out.println("veuillez entrer le nom de l'etudiant");
			nom = sc.next();
			System.out.println("veuillez entrer le prenom de l'etudiant");
			prenom = sc.next();
			System.out.println("veuillez entrer l'email de l'etudiant");
			email = sc.next();
			System.out.println("pour homme tapper 1 pour femme tapper 2");
			if(sc.nextInt() == 1) civilite = Civilite.Monsieur ;
			else civilite = Civilite.Madame ;
			try {
				String dattmp ;
			System.out.println("enter la date de naissance selon la forme dd-mm-yyyy");
			 dattmp = sc.next();
			  date= df.parse(dattmp);
			} catch (ParseException e){
			  e.fillInStackTrace();
			}
			Etudiant et = new Etudiant(nom, prenom, email, date, civilite) ;
			etudiantdao.ajouterEtudiant(et);
			System.out.println("Etudiant ajouter avec succes");
			System.out.println();
			System.out.println("1-Retour");
			System.out.println("2 -fermer le programme");
			i=sc.nextInt();
			if(i==1)
			   break ;
				
			}
			
			
			case 2 :{
				etudiantdao.afficherListEtudiant();
				System.out.println("1-Retour");
				System.out.println("2 -fermer le programme");
				i=sc.nextInt();
				if(i==1)
				  break ;
			}
		
			case 3 :{
				System.out.println("entrer le nom d'etuddiat a supprimer");
				nom = sc.next() ;
				if(etudiantdao.supprimerEtudiant(nom)) System.out.println("suppression effectue");
				else System.out.println("Nom n'est pas dans la liste des etudiants");
				System.out.println("1-Retour");
				System.out.println("2 -fermer le programme");
				i=sc.nextInt();
				if(i==1)
				  break ;
			}
			
			
			case 4 :{
				etudiantdao.afficherSelonNom() ;
				System.out.println("1-Retour");
				System.out.println("2 -fermer le programme");
				i=sc.nextInt();
				if(i==1)
				  break ;
				}
			
			
			case 5 :{
				etudiantdao.afficherSelonDate();				
				System.out.println("1-Retour");
				System.out.println("2 -fermer le programme");
				i=sc.nextInt();
				if(i==1)
				  break ;
				
			}
			
			
			case 6 :{
				System.exit(1);}
			}
		}
	
		
	}

}
