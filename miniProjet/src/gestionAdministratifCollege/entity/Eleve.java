package gestionAdministratifCollege.entity;

import java.util.ArrayList;


public class Eleve extends Personne{
	private static int id = 1;
	private int idEleve;
	private String dateInscription;
	private String telephonePere;
	private String telephoneMere;
	private Classe classe;
	private ArrayList<Absence> absent;
	  
	String clas ,  cour ,justification;
	
	public Eleve(String nom, String prenom, String dateNaissance, Classe classe) 
	{
		super(nom, prenom, dateNaissance);
		this.idEleve = id++;
		this.classe = classe;
	}
	
	
	
	public Eleve(int id ,String nom, String prenom, String dateNaissance , String classe) 
	{
		super(nom, prenom, dateNaissance);
		this.idEleve = id ;
		this.clas = classe;
	}
	
	/*public Eleve(String nom, String prenom, String dateNaissance) 
	{
		super(nom, prenom, dateNaissance);
	}*/
	public Eleve( int idEleve , String nom, String prenom , String dateNaissance , String cour, String justification)
	{
		super(nom, prenom, dateNaissance);
		this.idEleve = idEleve ;
		this.cour = cour ;
		this.justification = justification ;
	}
	
	public String getCour() {
		return cour;
	}
	
	public String getclas() {
		return clas;
	}
	
	public String getJustification() {
		return justification;
	}
	
	public void affiche()
	{
		System.out.println(super.toString() + " ;classe :" + classe.getClasse());
	}
	
	 public String toString() 
	  {
		  return idEleve + " : " + super.toString();
	  }
	public void ajouterAbsence(Absence abs)
	{
		absent.add(abs);
	}

	public void suprimerAbsence(Absence abs)
	{
		absent.remove(abs);
	}
	

	 public void modifierClasee(Classe nouvClasse)
	  {
		 setClasse(nouvClasse);
	  }
	
	
	
	 
	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getTelephonePere() {
		return telephonePere;
	}

	public void setTelephonePere(String telephonePere) {
		this.telephonePere = telephonePere;
	}

	public String getTelephoneMere() {
		return telephoneMere;
	}

	public void setTelephoneMere(String telephoneMere) {
		this.telephoneMere = telephoneMere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
}
