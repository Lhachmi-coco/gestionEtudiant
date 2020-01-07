package gestionEtudiant.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gestionEtudiant.model.Etudiant;

public class EtudiantDAO {
	
	// Liste Des etudiants 
	List<Etudiant> etudiants = new ArrayList<>();
	
	// ajouter un etudiant à ma liste
	public void ajouterEtudiant(Etudiant e) {
		etudiants.add(e);
	}
	
	// supprimer un etudiant par son nom
	public Boolean supprimerEtudiant(String nom) {
		
		for(Etudiant e : etudiants) {
		if(e.getNom().equals(nom)) return etudiants.remove(e);
		}
		return false ;
		
	}
	
	// Afficher Liste Etudiant
	public void afficherListEtudiant() {
		int i =1;
		for(Etudiant e : etudiants) {
			System.out.println(i+"-"+e);
			i++;
		}
	}
	
	// Afficher Liste Etudiant selon nom Ascendant
	public void afficherSelonNom() {
		Comparator<Etudiant> comparator = new Comparator<Etudiant>() {
			
			@Override
			public int compare(Etudiant o1, Etudiant o2) {
				return o1.getNom().compareTo(o2.getNom());
			}
		};
		Collections.sort(etudiants, comparator);
		afficherListEtudiant();
	}
	
	//Afficher Liste Etudiants selon Date Descendante
	
	public void afficherSelonDate() {
Comparator<Etudiant> comparator = new Comparator<Etudiant>() {
			
			@Override
			public int compare(Etudiant o1, Etudiant o2) {
				return -o1.getDateNaissance().compareTo(o2.getDateNaissance());
			}
		};
		Collections.sort(etudiants, comparator);
		afficherListEtudiant();
	}
		
		
	
     
}
