package gestionAdministratifCollege;

import java.util.ArrayList;


public class Enseignant extends Personne{
	private int id ;
	private String cin;
	private String telephone;
	private String mail;
	private ArrayList<Cour>  listeCours;

	public Enseignant(String cin , String nom, String prenom, String dateNaissance , String email , String tele) 
	{
		super(nom, prenom, dateNaissance);
		id++ ;
		this.cin = cin ;
		this.mail = email ;
		this.telephone = tele ;
		this.listeCours = new ArrayList<Cour>();
	}
	
	
	
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





	public ArrayList<Cour> getListeCours() {
		return listeCours;
	}





	public void setListeCours(ArrayList<Cour> listeCours) {
		this.listeCours = listeCours;
	}





	public void ajouterCour(Cour cour)
	  {
		  listeCours.add(cour);
	  }
	  
	  public void supprimerCour(Cour cour)
	  {
		  listeCours.remove(cour);
	  }
	  
	
	
	  public String toString() {
	  return  "CIN : " + cin + super.toString() + " liste des cours qui enseigne " +listeCours;
	  }
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	  

}
