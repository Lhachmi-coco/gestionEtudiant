package gestionEtudiant.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Etudiant {
	
	//Class Etudiant 
	
	private String	nom ;
	private String prenom ;
	private String email ;
	private Date dateNaissance ;
	private Civilite civilite ;
	
	public Etudiant(String nom, String prenom, String email, Date dateNaissance, Civilite civilite) {
		super();this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.civilite = civilite;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return "Nom : "+nom+" Prenom : "+prenom+" DateNaissance : "+df.format(dateNaissance)+" Civilite : "+civilite;
	}
}
